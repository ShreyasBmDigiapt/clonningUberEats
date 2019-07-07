package com.example.clonningubereats.login;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.clonningubereats.R;
import com.example.clonningubereats.login.loginFragments.LoginFragment1;

public class LoginActivty extends AppCompatActivity {

    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activty);

        transaction = getSupportFragmentManager().beginTransaction();
        LoginFragment1 fragment1 = new LoginFragment1();
        transaction.add(R.id.mainFrame, fragment1);
        transaction.commit();
    }
}
