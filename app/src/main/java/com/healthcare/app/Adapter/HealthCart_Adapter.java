package com.healthcare.app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.healthcare.app.R;

import java.util.ArrayList;

public class HealthCart_Adapter extends RecyclerView.Adapter<HealthCart_Adapter.ViewHolder> {


    Context context;
    ArrayList<Integer> img_heal_supp;

    public HealthCart_Adapter(Context context,  ArrayList<Integer> img_heal_supp){
        this.context=context;
        this.img_heal_supp=img_heal_supp;

    }


    @Override
    public HealthCart_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_healthcart,parent,false);
        return new HealthCart_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HealthCart_Adapter.ViewHolder holder, int position) {

        Glide.with(context).load(img_heal_supp.get(position)).into(holder.cat_img);

    }


    @Override
    public int getItemCount() {
        return img_heal_supp.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView cat_img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cat_img=itemView.findViewById(R.id.cat_img);

        }
    }


}