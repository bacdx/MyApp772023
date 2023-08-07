package com.example.myapp772023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapp772023.Broadcast.MyBroadcast;
import com.example.myapp772023.Model.BlockChat;
import com.example.myapp772023.Service.MyService;
import com.example.myapp772023.config.MyConnect;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class ActivityFormLogin extends AppCompatActivity {
    MyBroadcast myBroadcast;
    TextInputEditText edName,edPass;
    public Button btnLogin;

    ArrayList<BlockChat> A= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);
        edName=findViewById(R.id.edName_loginform);
        edPass=findViewById(R.id.edPass_loginform);
        btnLogin=findViewById(R.id.btnLogin_formlogin);
        myBroadcast=new MyBroadcast();
        IntentFilter filter = new IntentFilter(MyConnect.ACTION_CHECK_USER);
        registerReceiver(myBroadcast, filter);




        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=edName.getText().toString();
                String pass=edPass.getText().toString();
                if(validate(name,pass)==true){
                    checkLogin(name,pass);
                }
            }
        });
    }

    //validate
    public boolean validate(String name,String pass){
        if(name==null||pass==null){
            return false;
        }
        else if(name==""||pass==""){
            return false;
        }
        else {
            return true;
        }

    }

    //checkdata
    public void checkLogin(String name,String pass){
        String data=name+","+pass;
        MyService.myConnect.pushData(MyConnect.ACTION_CHECK_USER,data);

    }

    @Override
    protected void onStop() {
        unregisterReceiver(myBroadcast);
        super.onStop();
    }

    public TextInputEditText getEdName() {
        return edName;
    }

    public void setEdName(TextInputEditText edName) {
        this.edName = edName;
    }

    public TextInputEditText getEdPass() {
        return edPass;
    }

    public void setEdPass(TextInputEditText edPass) {
        this.edPass = edPass;
    }

    public Button getBtnLogin() {
        return btnLogin;
    }

    public void setBtnLogin(Button btnLogin) {
        this.btnLogin = btnLogin;
    }
}