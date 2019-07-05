package com.example.clonningubereats.history_fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.clonningubereats.R;
import com.example.clonningubereats.modelClass.HistoryItems;

import java.util.ArrayList;


public class HistoryViewReciptFragment extends Fragment {


    private TextView mHorderName, mHRestroName, mHorderSubTotal, mHOrderDiscount, mHOrdertax, mHOrderDeliveryFee, mHOrdertotal, mTvClose;
    private ArrayList<HistoryItems> historyItems;
    private int position;
    private Context context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public HistoryViewReciptFragment(ArrayList<HistoryItems> historyItems, int position) {
        this.historyItems = historyItems;
        this.position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history_view_recipt, container, false);

        mHorderName = view.findViewById(R.id.hOrderName);
        mHRestroName = view.findViewById(R.id.hOrderRestroName);
        mHorderSubTotal = view.findViewById(R.id.hOrderSubtotal);
        mHOrdertotal = view.findViewById(R.id.hOrderTotal);
        mHOrderDiscount = view.findViewById(R.id.hOrderDiscount);
        mHOrdertax = view.findViewById(R.id.hOrderTax);
        mHOrderDeliveryFee = view.findViewById(R.id.hOrderDeliverFee);
        mTvClose = view.findViewById(R.id.hOrderClose);

        HistoryItems items = historyItems.get(position);
        mHorderName.setText(items.getHistoryOrderName());
        mHorderSubTotal.setText(items.getHistorySubToatal());
        mHRestroName.setText(items.getHistoryRestroName());
        mHOrderDiscount.setText(items.getHistoryDiscount());
        mHOrdertax.setText(items.getHistoryTax());
        mHOrdertotal.setText(items.getHistoryOrderTotal());
        mHOrderDeliveryFee.setText(items.getHistoryDeliveryFee());

        mTvClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStackImmediate();
            }
        });
        return view;

    }



}
