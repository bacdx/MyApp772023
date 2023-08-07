package com.example.myapp772023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;


import com.example.myapp772023.Adapter.FragmentAdapter;
import com.example.myapp772023.Manager.AccountManager;
import com.example.myapp772023.Model.Account;
import com.example.myapp772023.Model.BlockChat;
import com.example.myapp772023.fragment.BlockChatFragment;
import com.example.myapp772023.fragment.MessageFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

LinearLayout layoutFrg;
TabLayout tabLayout;
Toolbar toolbar;
FragmentAdapter fragmentAdapter;
FragmentManager fragmentManager;
BottomNavigationView bottomNavigationView;
Thread threadForcustListData;
Account account;

ArrayList<BlockChat> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tablayout_main_activity);
        layoutFrg = findViewById(R.id.layout_main_frg);
        toolbar = findViewById(R.id.toolbar_mainactivity);
        bottomNavigationView =findViewById(R.id.bottom_nav);
        fragmentManager = getSupportFragmentManager();

        account= AccountManager.account;




   ;


        setSupportActionBar(toolbar);
        toolbar.showOverflowMenu();
        tabLayout.setBackgroundColor(Color.BLACK);
        fragmentAdapter = new FragmentAdapter(this);

        fragmentManager.beginTransaction().add(new MessageFragment(), "messageFragment");
        fragmentManager.beginTransaction().add(new BlockChatFragment(), "groupChatFragment");
        fragmentManager.beginTransaction().replace(R.id.layout_main_frg, new BlockChatFragment(), "groupChatFragment").commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.favorite:
                        fragmentManager.beginTransaction().replace(R.id.layout_main_frg,new BlockChatFragment(), "groupChatFragment").commit();
                        break;
                    case R.id.message:
                        fragmentManager.beginTransaction().replace(R.id.layout_main_frg,new MessageFragment(), "messageFragment").commit();
                        break;
                    default:
                        fragmentManager.beginTransaction().replace(R.id.layout_main_frg,new BlockChatFragment(), "groupChatFragment").commit();
                        break;
                }
                return true;
            }
        });

    }

    public List getListMessage(){


        return null;
    }
    public void setListMessage(ArrayList<BlockChat> list){
        this.list=list;

    }



}