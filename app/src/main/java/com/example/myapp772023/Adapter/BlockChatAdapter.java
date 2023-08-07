package com.example.myapp772023.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp772023.Model.BlockChat;
import com.example.myapp772023.Model.Groupchat;
import com.example.myapp772023.R;

import java.util.ArrayList;

public class BlockChatAdapter extends RecyclerView.Adapter<BlockChatAdapter.Hodler> {

    ArrayList<BlockChat> groupchats=new ArrayList<>();

    BlockChat groupchat;
    Context context;
    public BlockChatAdapter(Context context, ArrayList<BlockChat> groupchats) {
        this.groupchats=groupchats;
        this.context = context;

    }

    @NonNull
    @Override
    public BlockChatAdapter.Hodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.item_groupchat,null);
        return new Hodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BlockChatAdapter.Hodler holder, int position) {
        groupchat=groupchats.get(position);
        holder.txtGroupName.setText(groupchat.getName());
        holder.txtContent.setText(groupchat.getId());
    }

    @Override
    public int getItemCount() {
        return groupchats.size();
    }

    public class Hodler extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txtGroupName,txtContent;
        public Hodler(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.imv_avatar_group);
            txtGroupName=itemView.findViewById(R.id.txt_groupname);
            txtContent=itemView.findViewById(R.id.txt_content);
        }
    }
}
