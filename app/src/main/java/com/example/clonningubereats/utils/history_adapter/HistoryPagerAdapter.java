package com.example.clonningubereats.utils.history_adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.clonningubereats.history_fragment.HistoryRvFragment;
import com.example.clonningubereats.modelClass.RTL_model;

import java.util.ArrayList;

public class HistoryPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<RTL_model> mList;

    public HistoryPagerAdapter(@NonNull FragmentManager fm, int behavior, ArrayList<RTL_model> mList) {
        super(fm, behavior);
        this.mList = mList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        HistoryRvFragment fragment = new HistoryRvFragment(mList.get(position).getHistoryItems());
        return fragment;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    public RTL_model getTabTitle(int position) {
        return mList.get(position);
    }
}
