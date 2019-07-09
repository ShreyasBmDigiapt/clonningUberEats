package com.example.clonningubereats.offer_fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.clonningubereats.R;
import com.example.clonningubereats.modelClass.OfferMainImagePosition;
import com.example.clonningubereats.modelClass.OfferModel;
import com.example.clonningubereats.modelClass.RTL_model;
import com.example.clonningubereats.utils.offer_adapters.OfferPagerAdapter;
import com.example.clonningubereats.utils.offer_adapters.OfferRTLAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.nshmura.recyclertablayout.RecyclerTabLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class OfferFragment extends Fragment {

    private ArrayList<RTL_model> mList;
    private OfferPagerAdapter adapter;
    public ViewPager mOfferViewPager;
    private RecyclerTabLayout mRTL;
    private ImageView mImageView;
    private static final String TAG = "OfferFragment1";
    private int pos;

    private FirebaseFirestore mDb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public ArrayList<RTL_model> getmList() {
        return mList;
    }

    public void setmList(ArrayList<RTL_model> mList) {
        this.mList = mList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_offer, container, false);

        mOfferViewPager = view.findViewById(R.id.offerViewPager);
        mImageView = view.findViewById(R.id.offerMainImage);
        mRTL = view.findViewById(R.id.offerRTL);
        mDb = FirebaseFirestore.getInstance();
        mList = new ArrayList<>();

        getData();

        Log.d(TAG, "onCompleteMlist: "+getmList().size());
        adapter = new OfferPagerAdapter(getFragmentManager(), 0, mList);
        Log.d(TAG, "onCreateView: "+mList.size());

        mOfferViewPager.setAdapter(adapter);
        mRTL.hasFixedSize();
        OfferRTLAdapter RTLadapter = new OfferRTLAdapter(mOfferViewPager);
        Log.d(TAG, "onCreateView: position"+ RTLadapter.getCurrentIndicatorPosition());
        Log.d(TAG, "onCreateView: "+mOfferViewPager.getCurrentItem());
        mRTL.setUpWithAdapter(RTLadapter);

        Log.d(TAG, "onCreateView: "+pos);
        mRTL.setIndicatorColor(Color.RED);
        Picasso.get().load(R.drawable.offer_main_pic).into(mImageView);
        return view;
    }

    private void getData() {
        mDb.collection("offers").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            ArrayList<OfferModel> models;
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    final List<DocumentSnapshot> snapshot = task.getResult().getDocuments();
                    for (final DocumentSnapshot doc : snapshot) {
                        mDb.collection("offers").document(doc.getId()).collection("offerItems").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                models = new ArrayList<>();
//                                Log.d(TAG, "onComplete: "+task.getResult().getDocuments());
                                if (task.isSuccessful()) {
                                   List<DocumentSnapshot> snapshot1 = task.getResult().getDocuments();
                                   for (DocumentSnapshot doc1 : snapshot1) {
                                       models.add(new OfferModel(doc1.getString("offerImageUrl"), doc1.getString("offerSingleTitle"), doc1.getString("offerSingleSubTitle"), doc1.getString("offerSingleTime"), doc1.getString("offerSingleRatings") ));
                                   }
                                    mList.add(new RTL_model(models, doc.getString("tabTitle"), doc.getString("imageURLS")));
                                   setmList(mList);
                                    Log.d(TAG, "onCompleteSize: "+models.size());
                                    adapter.notifyDataSetChanged();
                                }
                                adapter.notifyDataSetChanged();
                            }
                        });
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }
}


