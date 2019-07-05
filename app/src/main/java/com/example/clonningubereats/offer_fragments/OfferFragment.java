package com.example.clonningubereats.offer_fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.clonningubereats.R;
import com.example.clonningubereats.modelClass.OfferModel;
import com.example.clonningubereats.modelClass.RTL_model;
import com.example.clonningubereats.utils.offer_adapters.OfferPagerAdapter;
import com.example.clonningubereats.utils.offer_adapters.OfferRTLAdapter;
import com.nshmura.recyclertablayout.RecyclerTabLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class OfferFragment extends Fragment {

    private ArrayList<RTL_model> mList;
    private ArrayList<OfferModel> offerList;
    private OfferPagerAdapter adapter;
    public ViewPager mOfferViewPager;
    private RecyclerTabLayout mRTL;
    private ImageView mImageView;
    private static final String TAG = "OfferFragment1";
    private int pos = 0;

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

        offerList = new ArrayList<>();
        offerList.add(new OfferModel(images[0], "Food1", "from restro7", "21:20", "4.5"));
        offerList.add(new OfferModel(images[0], "Food2", "from restro6", "20:20", "3.5"));
        offerList.add(new OfferModel(images[0], "Food3", "from restro5", "19:20", "2.5"));
        offerList.add(new OfferModel(images[0], "Food4", "from restro4", "218:20", "5.0"));
        offerList.add(new OfferModel(images[0], "Food5", "from restro3", "217:20", "4.3"));
        offerList.add(new OfferModel(images[0], "Food6", "from restro2", "216:20", "4.2"));
        offerList.add(new OfferModel(images[0], "Food7", "from restro1", "21520", "4.1"));

        mList = new ArrayList<>();
        mList.add(new RTL_model(offerList, "tab1", images[0]));
        mList.add(new RTL_model(offerList, "tab tab2", images[1]));
        mList.add(new RTL_model(offerList, "tab tab tab3", images[2]));

        Picasso.get().load(mList.get(mOfferViewPager.getCurrentItem()).getImageURLS()).into(mImageView);
        Log.d(TAG, "onCreateView: "+mOfferViewPager.getCurrentItem());

        adapter = new OfferPagerAdapter(getFragmentManager(), 0, mList);
        mOfferViewPager.setAdapter(adapter);
        mRTL.hasFixedSize();
        mRTL.setUpWithAdapter(new OfferRTLAdapter(mOfferViewPager));
        mRTL.setIndicatorColor(Color.RED);
        return view;
    }

}
