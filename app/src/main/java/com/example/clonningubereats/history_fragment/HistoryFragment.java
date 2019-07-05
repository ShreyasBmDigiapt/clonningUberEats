package com.example.clonningubereats.history_fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.clonningubereats.R;
import com.example.clonningubereats.modelClass.HistoryItems;
import com.example.clonningubereats.modelClass.RTL_model;
import com.example.clonningubereats.utils.history_adapter.HistoryPagerAdapter;
import com.example.clonningubereats.utils.history_adapter.HistoryRTLAdapter;
import com.nshmura.recyclertablayout.RecyclerTabLayout;

import java.util.ArrayList;


public class HistoryFragment extends Fragment {

    public ViewPager mHisotryViewPager;
    private HistoryPagerAdapter adapter;
    private ArrayList<RTL_model> mList;
    private ArrayList<HistoryItems> hItems, uList;
    private RecyclerTabLayout mRTL;
    private int pos;

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
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        hItems = new ArrayList<>();
        hItems.add(new HistoryItems(images[0],"Restro1", "Delivered", "24/01/19 15:20", "Order #23463",
                "Indian dish", "JHO", "Rs. 3", "Rs. 101", "Rs. 4", "4.25%", "95.02"));

        hItems.add(new HistoryItems(images[1],"Restro2", "Delivered", "25/02/19 17:21", "Order #14545",
                "Indian dish", "JHON", "Rs. 2", "Rs. 102", "Rs. 45", "8.25%", "80.02"));

        hItems.add(new HistoryItems(images[2],"Restro3", "Delivered", "27/03/19 21:22", "Order #12345",
                "Indian dish", "JHONNY", "Rs. 1", "Rs. 103", "Rs. 10.98", "6.25%", "99.02"));

        uList = new ArrayList<>();
        uList.add(new HistoryItems(images[0],"Restro1", "Delivered", "27/03/19 21:20", "Order #12345",
                "Indian dish", "JHON", "Rs. 2", "Rs. 100", "Rs. 10.98", "4.25%", "95.02"));
        mList = new ArrayList<>();
        mList.add(new RTL_model(hItems, "PAST ORDERS"));
        mList.add(new RTL_model(uList, "Ucoming"));

        mRTL = view.findViewById(R.id.historyRTL);

        mHisotryViewPager = view.findViewById(R.id.historyViewPager);
        adapter = new HistoryPagerAdapter(getFragmentManager(), 0, mList);
        mHisotryViewPager.setAdapter(adapter);
        mRTL.setUpWithAdapter(new HistoryRTLAdapter(mHisotryViewPager));
        mRTL.setIndicatorColor(Color.BLACK);
        return view;
    }

}
