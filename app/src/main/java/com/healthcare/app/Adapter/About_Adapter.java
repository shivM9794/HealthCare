package com.healthcare.app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.healthcare.app.R;

import java.util.ArrayList;

public class About_Adapter extends RecyclerView.Adapter<About_Adapter.ViewHolder> {


    Context context;
    ArrayList<String> about_txt;

    public About_Adapter(Context context, ArrayList<String> about_txt){
        this.context=context;
        this.about_txt=about_txt;

    }


    @Override
    public About_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_about,parent,false);
        return new About_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull About_Adapter.ViewHolder holder, int position) {

     holder.txt_about.setText(about_txt.get(position));

    }


    @Override
    public int getItemCount() {
        return about_txt.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image_about;
        TextView txt_about;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image_about=itemView.findViewById(R.id.image_about);
            txt_about=itemView.findViewById(R.id.txt_about);

        }
    }
}
