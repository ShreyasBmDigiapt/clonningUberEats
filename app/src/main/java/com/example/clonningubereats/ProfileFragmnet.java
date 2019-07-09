package com.example.clonningubereats;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.clonningubereats.login.LoginActivty;
import com.google.firebase.auth.FirebaseAuth;


public class ProfileFragmnet extends Fragment {

    private FirebaseAuth auth;
    private Button mBtnSignOut;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        auth = FirebaseAuth.getInstance();
        mBtnSignOut = view.findViewById(R.id.profileSignOut);

        mBtnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                getActivity().finish();
                startActivity(new Intent(getActivity(), LoginActivty.class));


            }
        });
        return  view;
    }

}
