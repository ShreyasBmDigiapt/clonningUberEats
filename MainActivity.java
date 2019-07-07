package com.example.clonningubereats;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.clonningubereats.history_fragment.HistoryFragment;
import com.example.clonningubereats.offer_fragments.OfferFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNav;
    private FirebaseAuth auth;
    private FirebaseFirestore mDb;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
        mDb = FirebaseFirestore.getInstance();

        mBottomNav = findViewById(R.id.nav_bar);
        mBottomNav.setOnNavigationItemSelectedListener(nav_listener);

        String name, pass;
        name = "shreyasbm@gmail.com";
        pass = "qwerty12345";
        auth.signInWithEmailAndPassword(name, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

            }
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new HomeFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener nav_listener = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    Fragment selectFragment = null;

                    switch (menuItem.getItemId()) {
                        case R.id.home1:
                            selectFragment = new HomeFragment();
                            break;

                        case R.id.search:
                            selectFragment = new SearchFragment();
                            break;


                        case R.id.history:
                            selectFragment = new HistoryFragment();
                            break;

                        case R.id.profile:
                            selectFragment = new ProfileFragmnet();
                            break;
                        case R.id.offer:
                            selectFragment = new OfferFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, selectFragment).commit();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_container, selectFragment);
                    transaction.commit();
                    return true;
                }
            };


}
