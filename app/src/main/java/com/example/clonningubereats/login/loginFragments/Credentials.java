package com.example.clonningubereats.login.loginFragments;

import com.google.firebase.auth.PhoneAuthProvider;

public interface Credentials {

    void code(String code);
    void onCodeSent(String s);
}
