package com.example.clonningubereats.login.loginFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.clonningubereats.R;


public class LoginFragment1 extends Fragment {

    private LinearLayout mFrame2;
    private LinearLayout mLinearLayout;
    private TextView mTvText;
    private FragmentTransaction transaction;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login_fragment1, container, false);

        mFrame2 = view.findViewById(R.id.frame2);
        mLinearLayout = view.findViewById(R.id.loginLinearLayout);
        mTvText = view.findViewById(R.id.loginText);

        mFrame2.animate().translationY(-400);

        onClick();
        return view;
    }

    private void onClick() {
        mTvText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.setCustomAnimations(R.animator.bottom_to_top,0);
                transaction.add(R.id.mainFrame, new NumberFragment2());

                transaction.addToBackStack("frag1");

                transaction.commit();
            }
        });
    }

}
