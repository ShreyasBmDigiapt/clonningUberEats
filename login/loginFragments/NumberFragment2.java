package com.example.clonningubereats.login.loginFragments;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.clonningubereats.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.FirebaseFirestore;


public class NumberFragment2 extends Fragment {

    private Toolbar mFrag2Tb;
    private EditText mEtNumber;
    private Button mFrag2BtnNext;

    private Boolean b=true;

    private FragmentTransaction transaction;

    private PhoneAuthProvider authProvider;
    private FirebaseAuth auth;
    private FirebaseUser user;
    private String phoneNumber;

    private static final String TAG = "NumberFragment21";


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
        auth = FirebaseAuth.getInstance();

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
                    OtpFragment3 fragment3 = new OtpFragment3();
                    Bundle bundle = new Bundle();
                    bundle.putString("phoneNumber", phoneNumber);
                    fragment3.setArguments(bundle);
                    transaction.replace(R.id.mainFrame, fragment3);
                    transaction.addToBackStack("frag2");
                    transaction.commit();
                }else {
                    transaction.replace(R.id.mainFrame, new PassFragment4());
                    transaction.addToBackStack("frag3");
                    transaction.commit();
                }
            }
        });
    }

}
