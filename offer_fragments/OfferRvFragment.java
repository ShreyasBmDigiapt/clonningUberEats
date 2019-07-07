package com.example.clonningubereats.offer_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clonningubereats.R;
import com.example.clonningubereats.modelClass.OfferModel;
import com.example.clonningubereats.utils.offer_adapters.OfferRvAdapter;

import java.util.ArrayList;


public class OfferRvFragment extends Fragment {
    private RecyclerView mRv;
    private ArrayList<OfferModel> mList;

    public OfferRvFragment(ArrayList<OfferModel> mList) {
        this.mList = mList;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_offer_rv, container, false);
        mRv = itemView.findViewById(R.id.offerRv);
        OfferRvAdapter adapter = new OfferRvAdapter(mList, getContext());
        mRv.setLayoutManager(new LinearLayoutManager(getContext()));
        mRv.setAdapter(adapter);
        return  itemView;
    }

}
