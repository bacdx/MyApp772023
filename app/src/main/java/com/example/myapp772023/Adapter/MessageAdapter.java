package com.example.myapp772023.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp772023.Model.Massage;
import com.example.myapp772023.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.Holder> {

    private ArrayList<Massage> list=new ArrayList<>();
    private Context context;

    public MessageAdapter( Context context) {

        this.context = context;
        for (int i=0;i<=20;i++){
            Massage message=new Massage(1,1,1,"hello","00-00-00-00");
            list.add(message);
        }
    }

    @NonNull
    @Override
    public MessageAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_message,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.Holder holder, int position) {
        Massage message=list.get(position);
       Picasso.get().load("https://tse1.mm.bing.net/th?id=OIP.s6RuZ2Cv4DtF-HuEFALqKwHaHa&pid=Api&P=0&w=300&h=300").into(holder.avatar);
       holder.message.setText(message.getContent());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView avatar;
        TextView message;
        public Holder(@NonNull View itemView) {
            super(itemView);
            avatar=itemView.findViewById(R.id.avatar);
            message=itemView.findViewById(R.id.massage);
        }
    }
}
