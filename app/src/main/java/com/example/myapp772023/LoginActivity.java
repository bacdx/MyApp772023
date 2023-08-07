package com.example.myapp772023;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.myapp772023.Service.MyService;
import com.example.myapp772023.fragment.FormFragment;

public class LoginActivity extends AppCompatActivity {
    FragmentManager manager;
Button btnLogin, btnSignin;
LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin=findViewById(R.id.btnlogin);
        btnSignin=findViewById(R.id.btnsignin);
        linearLayout=findViewById(R.id.formlogin);
        manager=getSupportFragmentManager();

        // start Sevice
        Intent intent=new Intent(this, MyService.class);
        startService(intent);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this, ActivityFormLogin.class);
                startActivity(intent);
                finish();
            }
        });
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,SignInActivity.class);
                startActivity(intent);

            }
        });

    }
}