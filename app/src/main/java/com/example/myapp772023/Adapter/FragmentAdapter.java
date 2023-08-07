package com.example.myapp772023.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapp772023.fragment.BlockChatFragment;
import com.example.myapp772023.fragment.MessageFragment;

public class FragmentAdapter extends FragmentStateAdapter {
    public FragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position==0){
            return new BlockChatFragment();
        }else {
            return  new MessageFragment();
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
