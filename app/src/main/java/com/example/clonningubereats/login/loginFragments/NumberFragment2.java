package com.example.clonningubereats.login.loginFragments;

import android.os.Build;
import android.os.Bundle;
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


public class NumberFragment2 extends Fragment {

    private Toolbar mFrag2Tb;
    private EditText mEtNumber;
    private Button mFrag2BtnNext;

    private Boolean b=true;

    private FragmentTransaction transaction;

    private PhoneAuthProvider authProvider;
    private String phoneNumber;


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

        mFrag2Tb.setNavigationIcon(R.drawable.back);

        authProvider = PhoneAuthProvider.getInstance();
        phoneNumber = mEtNumber.getText().toString();


        mFrag2Tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();

            }
        });

        nextClick();
        return view;
    }

    private void nextClick() {
        transaction = getActivity().getSupportFragmentManager().beginTransaction();
        mFrag2BtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (b) {
                    transaction.replace(R.id.mainFrame, new OtpFragment3());
                    transaction.addToBackStack("frag2");
                    transaction.commit();
                }else {
                    transaction.replace(R.id.mainFrame, new PassFragment4());
                    transaction.addToBackStack("frag2");
                    transaction.commit();
                }
            }
        });
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

        }
    };



}
