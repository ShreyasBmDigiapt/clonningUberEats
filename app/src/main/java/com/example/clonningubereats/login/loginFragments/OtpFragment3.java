package com.example.clonningubereats.login.loginFragments;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.clonningubereats.R;

public class OtpFragment3 extends Fragment {

    private Toolbar mOtpTT;
    private FragmentTransaction transaction;
    private EditText mEtOtp;
    private Button mOtpBtnNext;
    private TextView mOtpTv;
    private LinearLayout mTroubleFrame2;
    private FrameLayout mTroubleFrame;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_otp_fragment3, container, false);

        mOtpTT = view.findViewById(R.id.otpTT);
        transaction = getActivity().getSupportFragmentManager().beginTransaction();
        mEtOtp = view.findViewById(R.id.etOtp);
        mOtpBtnNext = view.findViewById(R.id.otpBtnClick);
        mOtpTv = view.findViewById(R.id.otpTv);
        mTroubleFrame2 = view.findViewById(R.id.troubleFrame2);
        mTroubleFrame = view.findViewById(R.id.troubleFrame1);

        mOtpTT.setNavigationIcon(R.drawable.back);
        mOtpTT.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });


        mOtpBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTroubleFrame.setBackgroundColor(getResources().getColor(R.color.trans_black));
                mTroubleFrame2.animate().translationY(-600);
                mTroubleFrame.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mTroubleFrame.setBackgroundColor(Color.TRANSPARENT);
                        mTroubleFrame2.animate().translationY(600);
                    }
                });

            }
        });

        return view;
    }

}
