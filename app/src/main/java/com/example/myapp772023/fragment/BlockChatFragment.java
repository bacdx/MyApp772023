package com.example.myapp772023.fragment;

import android.content.IntentFilter;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp772023.Adapter.BlockChatAdapter;

import com.example.myapp772023.Broadcast.MyBroadcast;
import com.example.myapp772023.Manager.AccountManager;
import com.example.myapp772023.Manager.BlockChatManager;
import com.example.myapp772023.Model.Groupchat;
import com.example.myapp772023.R;
import com.example.myapp772023.Service.MyService;
import com.example.myapp772023.config.MyConnect;


public class BlockChatFragment extends Fragment {
        Groupchat groupchat;
RecyclerView recyclerView;
BlockChatAdapter groupChatAdapter;
    MyBroadcast myBroadcast;
    public BlockChatFragment() {
        Groupchat groupchat=new Groupchat();


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myBroadcast=new MyBroadcast();
        IntentFilter filter = new IntentFilter(MyConnect.ACTION_GET_BLOCKCHAT);
        getActivity().registerReceiver(myBroadcast, filter);

        MyConnect myConnect= MyService.myConnect;
        myConnect.pushData(MyConnect.ACTION_GET_BLOCKCHAT, AccountManager.account.getId());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_group_chat, container, false);
        recyclerView=view.findViewById(R.id.ryview_groupchat);
        LinearLayoutManager manager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,true);

        recyclerView.setLayoutManager(manager);
        groupChatAdapter =new BlockChatAdapter(getContext(), BlockChatManager.list);
        recyclerView.setAdapter(groupChatAdapter);
        return view;
    }
}