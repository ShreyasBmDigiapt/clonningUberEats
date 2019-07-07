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
import com.example.clonningubereats.modelClass.OfferModel;
import com.example.clonningubereats.modelClass.RTL_model;
import com.example.clonningubereats.utils.offer_adapters.OfferPagerAdapter;
import com.example.clonningubereats.utils.offer_adapters.OfferRTLAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firestore.v1beta1.ListDocumentsResponse;
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
    private int pos = 0;

    private FirebaseFirestore mDb;

    public static String[] images = {
            "https://images.pexels.com/photos/414612/pexels-photo-414612.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/67636/rose-blue-flower-rose-blooms-67636.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://cdn.pixabay.com/photo/2018/02/09/21/46/rose-3142529__340.jpg"
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_offer, container, false);

        //fireBase
        mDb = FirebaseFirestore.getInstance();

        mList = new ArrayList<>();
        mOfferViewPager = view.findViewById(R.id.offerViewPager);
        mImageView = view.findViewById(R.id.offerMainImage);
        mRTL = view.findViewById(R.id.offerRTL);

        adapter = new OfferPagerAdapter(getFragmentManager(), 0, mList);
        mOfferViewPager.setAdapter(adapter);


        Log.d(TAG, "onCreateView: " + mOfferViewPager.getCurrentItem());


        mRTL.hasFixedSize();
        mRTL.setUpWithAdapter(new OfferRTLAdapter(mOfferViewPager));
        mRTL.setIndicatorColor(Color.RED);

        mDb.collection("offers").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    List<DocumentSnapshot> document = task.getResult().getDocuments();
                    for (DocumentSnapshot doc : document) {
                        getData(doc.getId(), doc.getString("tabTitle"), doc.getString("imageURLS"));
                    }
                }
            }
        });

        return view;
    }

    private void getData(String id, final String tabTitle, final String imageURLS) {
        mDb.collection("offers").document(id).collection("offerItems").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    List<DocumentSnapshot> docInner = task.getResult().getDocuments();
                    ArrayList<OfferModel> offerList = new ArrayList<>();
                    for (DocumentSnapshot doc : docInner) {
                        offerList.add(new OfferModel(doc.getString("offerImageUrl"), doc.getString("offerSingleTitle"), doc.getString("offerSingleSubTitle"), doc.getString("offerSingleTime"), doc.getString("offerSingleRatings")));
                    }
                    mList.add(new RTL_model(offerList, tabTitle, imageURLS));
                    adapter.notifyDataSetChanged();
                    Picasso.get().load(mList.get(mOfferViewPager.getCurrentItem()).getImageURLS()).into(mImageView);

                }
            }
        });
    }
}