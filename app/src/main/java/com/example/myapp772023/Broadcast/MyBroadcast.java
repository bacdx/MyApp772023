package com.example.myapp772023.Broadcast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.FragmentManager;

import com.example.myapp772023.ActivityFormLogin;
import com.example.myapp772023.LoginActivity;
import com.example.myapp772023.MainActivity;
import com.example.myapp772023.config.MyConnect;

public class MyBroadcast extends BroadcastReceiver {
    public boolean isCheckLogin=false;

    public boolean isCheckLogin() {
        return isCheckLogin;
    }

    public void setCheckLogin(boolean checkLogin) {
        isCheckLogin = checkLogin;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()){
            case MyConnect.ACTION_CHECK_USER:
                intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
                break ;
            case MyConnect.ACTION_GET_BLOCKCHAT:
                
                break ;


        }



    }



}
