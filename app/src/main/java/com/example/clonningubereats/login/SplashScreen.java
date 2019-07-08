package com.example.clonningubereats.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.clonningubereats.MainActivity;
import com.example.clonningubereats.R;
import com.google.firebase.auth.FirebaseAuth;

public class SplashScreen extends AppCompatActivity {

    private Handler handler1;
    private Runnable runnable1;
    private ImageView mIvSplash;
    private ProgressBar mPbSplash;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mIvSplash = findViewById(R.id.splashImage);
        mPbSplash = findViewById(R.id.splashProgressBar);

        mAuth = FirebaseAuth.getInstance();

        Glide.with(getApplicationContext()).load(R.drawable.ubereats).into(mIvSplash);

        if (mAuth.getCurrentUser() != null) {
            runnable1 = new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            };
            handler1 = new Handler();
            handler1.postDelayed(runnable1, 4000);
        }else {

            runnable1 = new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(getApplicationContext(), LoginActivty.class));
                    finish();
                }
            };
            handler1 = new Handler();
            handler1.postDelayed(runnable1, 2000);

        }




    }
}
