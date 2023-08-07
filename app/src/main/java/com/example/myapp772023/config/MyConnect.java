package com.example.myapp772023.config;

import android.util.Log;

import com.example.myapp772023.Model.BlockChat;
import com.example.myapp772023.Service.MyService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class MyConnect {
    public static final String ACTION_CHECK_USER = "0";
    public static final String ACTION_POST_MESSAGE = "1";
    public static final String ACTION_GET_IDACCOUNT = "2";
    public static final String ACTION_GET_BLOCKCHAT = "3";
    //    public  static  final String ACTION_GET_BLOCKCHAT="getblockchat";
//    public  static  final String ACTION_GET_="getblockchat";
//    public  static  final String ACTION_GET_BLOCKCHAT="getblockchat";
//    public  static
    static BufferedWriter os = null;
    static BufferedReader is = null;
    final String serverHost = "192.168.43.250";
    Socket socketOfClient = null;
    String data;

    ArrayList<ArrayList<String>>listData;
    boolean running = true;

    public String getServerHost() {
        return serverHost;
    }

    public Socket getSocketOfClient() {
        return socketOfClient;
    }

    public void setSocketOfClient(Socket socketOfClient) {
        this.socketOfClient = socketOfClient;
    }

    public BufferedWriter getOs() {
        return os;
    }

    public void setOs(BufferedWriter os) {
        MyConnect.os = os;
    }

    public BufferedReader getIs() {
        return is;
    }

    public void setIs(BufferedReader is) {
        MyConnect.is = is;
    }

    public void Conect() {


        try {

            // Gửi yêu cầu kết nối tới Server đang lắng nghe
            // trên máy 'localhost' cổng 9999.

            socketOfClient = new Socket(serverHost, 9999);

            // Tạo luồng đầu ra tại client (Gửi dữ liệu tới server)
            os = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));

            // Luồng đầu vào tại Client (Nhận dữ liệu từ server).
            is = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));

        } catch (UnknownHostException e) {
            Log.e("E", "Don't know about host " + serverHost);

        } catch (IOException e) {
            Log.e("E", "Couldn't get I/O for the connection to " + e.getMessage());

        }

        try {


            while (running) {
//                os.write("sad");
//                os.newLine();
//                os.flush();
                try {
                    String data = is.readLine();
                    if (data != null) {

                        Log.i("ok", data);
                        MyService.setData(this.data);
                    }






                } catch (IOException e) {
                    os.close();
                    is.close();
                    socketOfClient.close();
                    e.printStackTrace();
                }


            }


        } catch (UnknownHostException e) {
            System.err.println("Trying to connect to unknown host: " + e);
        } catch (IOException e) {
            System.err.println("IOException:  " + e);
        }
    }

    public void pushData(String request, String data) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<2;i++){
                    try {
                        os.newLine();
                        os.write(request + "," + data);
                        os.flush();
//                    String reqont =is.readLine();
//                   if (reqont!=null){
//                       Log.e("E",reqont);
//                       MyService.setData(subString(reqont));
//
//                   }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }



    public String[] subString(String data) {


        String[] d=null;
            d = data.split(",");

//       for (int i=0;i<=d.length;i++){
//
//
//       }

        return d;

    }



    public void closeConnect() {
        running = false;
        try {
            if (is != null)
                is.close();
            if (os != null)
                os.close();
            if (socketOfClient != null && !socketOfClient.isClosed())
                socketOfClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
