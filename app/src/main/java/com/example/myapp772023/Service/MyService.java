package com.example.myapp772023.Service;


import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.IBinder;

import com.example.myapp772023.Manager.AccountManager;
import com.example.myapp772023.Manager.BlockChatManager;
import com.example.myapp772023.Model.Account;
import com.example.myapp772023.Model.BlockChat;
import com.example.myapp772023.config.MyConnect;
import com.example.myapp772023.tool.ConverData;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MyService extends Service    {

    private static final String TAG = MyService.class.getSimpleName();


    private boolean running;
    public static MyConnect myConnect;
    public  static String data;
    ConverData converData;
    @Override
    public void onCreate() {

        super.onCreate();
        new Thread(new Runnable() {
            @Override
            public void run() {
                myConnect=new MyConnect();
                myConnect.Conect();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    if(data!=null){
                        converData=new ConverData(data);
                        // Gửi broadcast thông báo dữ liệu mới đến Activity/Fragment
                        switch (converData.getTitle()){
                            case MyConnect.ACTION_CHECK_USER :
                                Intent broadcastIntent = new Intent();
                                ArrayList<String> strings=converData.getData();
                                AccountManager.account.setId(strings.get(0));
                                AccountManager.account.setName(strings.get(1));
                                AccountManager.account.setEmail(strings.get(2));
                                AccountManager.account.setStt(strings.get(3));
                                AccountManager.account.setAge(strings.get(4));
                                AccountManager.account.setImg(strings.get(5));
                                AccountManager.account.setUserName(strings.get(6));
                                AccountManager.account.setPass(strings.get(7));
                                // gui tin hieu len activity
                                broadcastIntent.setAction(MyConnect.ACTION_CHECK_USER);
                                sendBroadcast(broadcastIntent);

                                data=null;
                                break;

                            case MyConnect.ACTION_GET_BLOCKCHAT:
                                Intent broadcastIntent1 = new Intent();
                                ArrayList<BlockChat> blockChats=new ArrayList<>();
                                ArrayList<ArrayList<String>> strings1=converData.getListData();
                                for (int i=0;i<= strings1.size();i++){
                                    BlockChat blockChat=new BlockChat();
                                    ArrayList<String>listData =strings1.get(i);
                                    blockChat.setId(listData.get(0));
                                    blockChat.setName(listData.get(2));
                                    blockChat.setImg(listData.get(3));
                                    blockChat.setImg(listData.get(4));
                                    blockChats.add(blockChat);
                                }
                                BlockChatManager.list=blockChats;
                                broadcastIntent1.setAction(MyConnect.ACTION_GET_BLOCKCHAT);
                                sendBroadcast(broadcastIntent1);

                        }


                    }






                }
            }
        }).start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Bắt đầu lắng nghe dữ liệu từ server


        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        myConnect.closeConnect();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    public boolean checkLogin(boolean check){
        return check;
    }

    public static String getData() {
        return data;
    }

    public static void setData(String data) {
        MyService.data = data;
    }
}
