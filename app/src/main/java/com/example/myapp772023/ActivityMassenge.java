package com.example.myapp772023;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapp772023.Adapter.MessageAdapter;

public class ActivityMassenge extends AppCompatActivity {
RecyclerView rcView;
MessageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_massenge);

        RecyclerView rcView=findViewById(R.id.ryview_messenge);
        adapter=new MessageAdapter(getApplicationContext());
        LinearLayoutManager manager=new LinearLayoutManager(getApplicationContext());
        rcView.setLayoutManager(manager);
        rcView.setAdapter(adapter);

    }
}