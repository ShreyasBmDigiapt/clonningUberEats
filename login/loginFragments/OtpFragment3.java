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
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.arch.core.executor.TaskExecutor;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.clonningubereats.MainActivity;
import com.example.clonningubereats.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class OtpFragment3 extends Fragment {

    private static final String TAG = "OtpFragment31";

    private Toolbar mOtpTT;
    private FragmentTransaction transaction;
    private EditText mEtOtp;
    private Button mOtpBtnNext;
    private TextView mOtpTv, mOTPText;
    private LinearLayout mTroubleFrame2;
    private FrameLayout mTroubleFrame;
    private String mVerificationId;
    private PhoneAuthProvider.ForceResendingToken mResendToken;

    private FirebaseAuth mAuth;
    private FirebaseUser user;

    private String phoneNumber;

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

        mAuth = FirebaseAuth.getInstance();

        mOtpTT = view.findViewById(R.id.otpTT);
        mOTPText = view.findViewById(R.id.otpText);
        transaction = getActivity().getSupportFragmentManager().beginTransaction();
        mEtOtp = view.findViewById(R.id.etOtp);
        mOtpBtnNext = view.findViewById(R.id.otpBtnClick);
        mOtpTv = view.findViewById(R.id.otpTv);
        mTroubleFrame2 = view.findViewById(R.id.troubleFrame2);
        mTroubleFrame = view.findViewById(R.id.troubleFrame1);

       phoneNumber = getArguments().getString("phoneNumber");

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

    private void senVerificationCode(String phoneNumber) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber("+91"+phoneNumber, 60, TimeUnit.SECONDS, TaskExecutors.MAIN_THREAD, mCallbacks);
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

            mVerificationId = s;
            mResendToken = forceResendingToken;

        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            String code= phoneAuthCredential.getSmsCode();

            if (code != null) {
                mEtOtp.setText(code);

                //verifying the code
                verifyVerificationCode(code);
            }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

        }
    };

    private void verifyVerificationCode(String otp) {
        //creating the credential
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, otp);

        //signing the user
        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //verification successful we will start the profile activity
                            startActivity(new Intent(getActivity(), MainActivity.class));
                            
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, "onFailure: "+e.getMessage());
            }
        });
    }

}
