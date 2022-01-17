package com.example.a16_recyclerview_pinterest_cells.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a16_recyclerview_pinterest_cells.R;
import com.example.a16_recyclerview_pinterest_cells.model.Member;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Member> members;

    public CustomAdapter(Context context, List<Member> members) {
        this.context = context;
        this.members = members;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);

        if(holder instanceof CustomViewHolder){

            ImageView image = ((CustomViewHolder) holder).item_image;
            if(position % 3 == 0){
                image.setImageResource(R.drawable.img);
            }else if(position % 4 == 0){
                image.setImageResource(R.drawable.img_1);
            }else if(position % 5 == 0){
                image.setImageResource(R.drawable.img_2);
            }else{
                image.setImageResource(R.drawable.img_3);
            }

        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    private class CustomViewHolder extends RecyclerView.ViewHolder {
        View view;
        ImageView item_image;
        public CustomViewHolder(View v) {
            super(v);
            view = v;
            item_image = view.findViewById(R.id.item_image);
        }
    }
}
