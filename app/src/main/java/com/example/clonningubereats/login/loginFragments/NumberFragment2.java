package com.example.clonningubereats.login.loginFragments;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.clonningubereats.R;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.hbb20.CountryCodePicker;

import java.util.concurrent.TimeUnit;


public class NumberFragment2 extends Fragment {

    private Toolbar mFrag2Tb;
    private EditText mEtNumber;
    private Button mFrag2BtnNext;
    private static final String TAG = "NumberFragment21";

    private Boolean b = true;

    private FragmentTransaction transaction;

    private PhoneAuthProvider authProvider;
    private CountryCodePicker mCCP;

    private OtpFragment3 fragment3;
    private  Bundle args;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_number_fragment2, container, false);
        mFrag2Tb = view.findViewById(R.id.frag2Tb);
        mEtNumber = view.findViewById(R.id.etNumber);
        mFrag2BtnNext = view.findViewById(R.id.frag2BtnNext);
        mCCP = view.findViewById(R.id.ccp);

        args = new Bundle();

        mFrag2Tb.setNavigationIcon(R.drawable.back);

        authProvider = PhoneAuthProvider.getInstance();
        transaction = getActivity().getSupportFragmentManager().beginTransaction();

        mFrag2Tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();

            }
        });

        mFrag2BtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextClick();
            }
        });


        return view;
    }

    private void nextClick() {
        final String phoneNumber =mCCP.getFullNumberWithPlus()+mEtNumber.getText().toString();
        Log.d(TAG, "nextClick: "+phoneNumber);
        if (phoneNumber.isEmpty()) {
            mEtNumber.setError("Enter your number");
            mEtNumber.requestFocus();
        } else if (b) {
            fragment3 = new OtpFragment3();
            args.putString("phoneNumber", phoneNumber);
            fragment3.setArguments(args);
            transaction.replace(R.id.mainFrame, fragment3);
            transaction.addToBackStack("frag2");
            transaction.commit();


        } else {
            transaction.replace(R.id.mainFrame, new PassFragment4());
            transaction.addToBackStack("frag2");
            transaction.commit();
        }
    }

}




