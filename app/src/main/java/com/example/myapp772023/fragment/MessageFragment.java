package com.example.myapp772023.fragment;

import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp772023.Broadcast.MyBroadcast;
import com.example.myapp772023.Manager.AccountManager;
import com.example.myapp772023.R;
import com.example.myapp772023.Service.MyService;
import com.example.myapp772023.config.MyConnect;


public class MessageFragment extends Fragment {






    public MessageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_message, container, false);
        view.setBackgroundColor(Color.GREEN);
        return view;

    }
}