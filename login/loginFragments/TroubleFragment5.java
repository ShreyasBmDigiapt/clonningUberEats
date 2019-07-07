package com.example.clonningubereats.login.loginFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;

import com.example.clonningubereats.R;

public class TroubleFragment5 extends Fragment {

    private FrameLayout mFrame1, mFrame2;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trouble_fragment5, container, false);

        mFrame1 = view.findViewById(R.id.troubleFrame1);
        mFrame2 = view.findViewById(R.id.troubleFrame2);
        mFrame2.animate().translationY(-625);

        mFrame1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
        return  view;
    }
}
