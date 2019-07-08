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
import com.nshmura.recyclertablayout.RecyclerTabLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class OfferFragment extends Fragment {

    private ArrayList<RTL_model> mList;
    private ArrayList<OfferModel> offerList;
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

        mOfferViewPager = view.findViewById(R.id.offerViewPager);
        mImageView = view.findViewById(R.id.offerMainImage);
        mRTL = view.findViewById(R.id.offerRTL);
        mDb = FirebaseFirestore.getInstance();
        mDb.collection("offers").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    List<DocumentSnapshot> documentSnapshots = task.getResult().getDocuments();
                    for (DocumentSnapshot doc : documentSnapshots) {
                        mList.add(new RTL_model(offerList, doc.getString("tabTitle"), doc.getString("imageURLS")));
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        });

        getData("offerItems");
        offerList = new ArrayList<>();
        offerList.add(new OfferModel(images[0], "Food7", "from restro1", "21520", "4.1"));

        mList = new ArrayList<>();


        Picasso.get().load(mList.get(mOfferViewPager.getCurrentItem()).getImageURLS()).into(mImageView);
        Log.d(TAG, "onCreateView: " + mOfferViewPager.getCurrentItem());

        adapter = new OfferPagerAdapter(getFragmentManager(), 0, mList);
        mOfferViewPager.setAdapter(adapter);
        mRTL.hasFixedSize();
        mRTL.setUpWithAdapter(new OfferRTLAdapter(mOfferViewPager));
        mRTL.setIndicatorColor(Color.RED);
        return view;
    }

    private void getData(String category) {
        mDb.collection(category).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            ArrayList<OfferModel> offerList = new ArrayList<>();
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    List<DocumentSnapshot> documentSnapshots = task.getResult().getDocuments();
                    for (DocumentSnapshot doc : documentSnapshots) {
                        offerList.add(new OfferModel(doc.getString("offerImageUrl"), doc.getString("offerSingleRatings"), doc.getString("offerSingleSubTitle"), doc.getString("offerSingleTime"), doc.getString("offerSingleTitle")));
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

}

/*offerList.add(new OfferModel(images[0], "Food1", "from restro7", "21:20", "4.5"));
        offerList.add(new OfferModel(images[0], "Food2", "from restro6", "20:20", "3.5"));
        offerList.add(new OfferModel(images[0], "Food3", "from restro5", "19:20", "2.5"));
        offerList.add(new OfferModel(images[0], "Food4", "from restro4", "218:20", "5.0"));
        offerList.add(new OfferModel(images[0], "Food5", "from restro3", "217:20", "4.3"));
        offerList.add(new OfferModel(images[0], "Food6", "from restro2", "216:20", "4.2"));*/


/*        mList.add(new RTL_model(offerList, "tab1", images[0]));
                mList.add(new RTL_model(offerList, "tab tab2", images[1]));
                mList.add(new RTL_model(offerList, "tab tab tab3", images[2]));*/

