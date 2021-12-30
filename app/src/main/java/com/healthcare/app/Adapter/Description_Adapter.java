package com.healthcare.app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;
import com.healthcare.app.HealthSolutions.Description_Tablayout;
import com.healthcare.app.R;
import com.healthcare.app.Response.SubCategoryType;

import java.util.ArrayList;
import java.util.List;

public class Description_Adapter extends RecyclerView.Adapter<Description_Adapter.ViewHolder> {


    Context context;
    List<SubCategoryType> subCategoryTypes;
    String image_path="https://apkconnectlab.com/healthcareapp/";

    public Description_Adapter(Context context,List<SubCategoryType> subCategoryTypes){
        this.context=context;
        this.subCategoryTypes=subCategoryTypes;

    }


    @Override
    public Description_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_description,parent,false);
        return new Description_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Description_Adapter.ViewHolder holder, int position) {

        holder.txt_about.setText(subCategoryTypes.get(position).getHeading());
        Glide.with(context).load(image_path+subCategoryTypes.get(position).getSubImage()).into(holder.image_hint);

        holder.card_des.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, Description_Tablayout.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });



    }


    @Override
    public int getItemCount() {
        return subCategoryTypes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image_about,image_hint;
        TextView txt_about;
        MaterialCardView card_des;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image_about=itemView.findViewById(R.id.image_about);
            txt_about=itemView.findViewById(R.id.txt_about);
            image_hint=itemView.findViewById(R.id.image_hint);
            card_des=itemView.findViewById(R.id.card_des);

        }
    }
}
