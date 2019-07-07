package com.example.clonningubereats.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.clonningubereats.MainActivity;
import com.example.clonningubereats.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.FirebaseFirestore;

public class SplashScreen extends AppCompatActivity {

    private Handler handler1;
    private Runnable runnable1;
    private ImageView mIvSplash;
    private ProgressBar mPbSplash;
    private FirebaseAuth auth;
    private FirebaseUser user;
    private FirebaseFirestore mDb;
    private PhoneAuthProvider phoneAuth;
    private static final String TAG = "SplashScreen1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        mIvSplash = findViewById(R.id.splashImage);
        mPbSplash = findViewById(R.id.splashProgressBar);

        Glide.with(getApplicationContext()).load(R.drawable.ubereats).into(mIvSplash);
        Log.d(TAG, "onCreate: "+user.getEmail().toString());

        if (user == null) {
            runnable1 = new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            };
            handler1 = new Handler();
            handler1.postDelayed(runnable1, 2000);
        } else {
            startActivity(new Intent(getApplicationContext(), LoginActivty.class));
            finish();
        }
    }
}
