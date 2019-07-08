package com.example.clonningubereats.login.loginFragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.arch.core.executor.TaskExecutor;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.clonningubereats.R;
import com.example.clonningubereats.login.SplashScreen;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OtpFragment3 extends Fragment {

    private Toolbar mOtpTT;
    private FragmentTransaction transaction;
    private EditText mEtOtp;
    private Button mOtpBtnNext;
    private TextView mOtpTv, mOtpTitle;
    private LinearLayout mTroubleFrame2;
    private FrameLayout mTroubleFrame;
    private static final String TAG = "OtpFragment31";
    private ProgressBar mOtpPB;
    private RelativeLayout mOtpRl;

    private Button mOtpCancel, mOtpResend;

    private String phoneNumber;
    private FirebaseAuth mAuth;
    private PhoneAuthProvider phoneAuthProvider;
    private String mVerificationId;
    private PhoneAuthProvider.ForceResendingToken mResndToken;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_otp_fragment3, container, false);

//        code = getArguments().getString("code").toString();
        mAuth = FirebaseAuth.getInstance();

        mOtpTT = view.findViewById(R.id.otpTT);
        transaction = getActivity().getSupportFragmentManager().beginTransaction();
        mEtOtp = view.findViewById(R.id.etOtp);
        mOtpBtnNext = view.findViewById(R.id.otpBtnClick);
        mOtpTv = view.findViewById(R.id.otpTv);
        mTroubleFrame2 = view.findViewById(R.id.troubleFrame2);
        mTroubleFrame = view.findViewById(R.id.troubleFrame1);
        mOtpPB = view.findViewById(R.id.otpPB);
        mOtpRl = view.findViewById(R.id.orpRL);
        mOtpTitle = view.findViewById(R.id.otpTitle);

        mOtpCancel = view.findViewById(R.id.otpCancel);
        mOtpResend = view.findViewById(R.id.otpResend);

        //phoneNumber
        phoneNumber = getArguments().getString("phoneNumber");

        mOtpTitle.setText("Enter the 4-digit code sent you " + phoneNumber);

        mOtpTT.setNavigationIcon(R.drawable.back);
        mOtpTT.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });


        mOtpTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEtOtp.setFocusable(false);
                mEtOtp.setClickable(false);
                mTroubleFrame.setBackgroundColor(getResources().getColor(R.color.trans_black));
                mTroubleFrame2.animate().translationY(-600);
            }
        });

        mOtpCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEtOtp.setFocusable(true);
                mEtOtp.setClickable(true);
                mTroubleFrame.setBackgroundColor(Color.TRANSPARENT);
                mTroubleFrame2.animate().translationY(600);
            }
        });

        verifyPhoneNumber(phoneNumber);

        mOtpResend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PhoneAuthProvider.getInstance().verifyPhoneNumber(phoneNumber, 60, TimeUnit.SECONDS,
                        getActivity(), mCallbacks, mResndToken);
                mTroubleFrame.setBackgroundColor(Color.TRANSPARENT);
                mTroubleFrame2.animate().translationY(600);
            }
        });
        return view;
    }

    private void verifyPhoneNumber(String phoneNumber) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(phoneNumber, 60, TimeUnit.SECONDS,
                getActivity(), mCallbacks);
    }


    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();

            if (code != null) {
                mEtOtp.setText(code);
            } else {

                Log.d(TAG, "onVerificationCompleted: error");
                Toast.makeText(getActivity(), "Invalid Number or try agian later", Toast.LENGTH_SHORT).show();
                getFragmentManager().popBackStack();
            }
            verifyVerificationCode(code);
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Log.d(TAG, "onVerificationFailed: " + e.getMessage());
            Toast.makeText(getActivity(), "Invalid Number or try agian later", Toast.LENGTH_SHORT).show();
            getFragmentManager().popBackStack();

        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            mVerificationId = s;
            mResndToken = forceResendingToken;
        }
    };

    private void verifyVerificationCode(String code) {


        mOtpBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEtOtp.getText().toString().isEmpty()) {
                    mEtOtp.requestFocus();
                    mEtOtp.setError("OTP");
                } else {
                    final PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, mEtOtp.getText().toString());
                    mOtpPB.setVisibility(View.VISIBLE);
                    signInWithCredential(credential);
                }
            }
        });
    }

    private void signInWithCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d(TAG, "onComplete: " + task.isSuccessful());
                if (task.isSuccessful()) {
                    mEtOtp.setFocusable(false);
                    mOtpBtnNext.setClickable(false);
                    mOtpPB.setVisibility(View.GONE);
                    mOtpRl.setBackground(getResources().getDrawable(R.color.trans_black));
                    startActivity(new Intent(getActivity(), SplashScreen.class));
                    getActivity().getSupportFragmentManager().popBackStackImmediate();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                mOtpPB.setVisibility(View.GONE);
                mOtpBtnNext.setClickable(true);
                mOtpRl.setBackground(getResources().getDrawable(R.color.white));
                Log.d(TAG, "onFailure: " + e.getMessage());
                Toast.makeText(getActivity(), "Invalid OTP", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
