package com.example.myapp772023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapp772023.Manager.AccountManager;

public class SignInActivity extends AppCompatActivity {
    AccountManager accountManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }
}