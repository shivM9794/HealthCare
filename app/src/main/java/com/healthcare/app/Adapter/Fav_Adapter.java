package com.healthcare.app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.healthcare.app.HealthSolutions.Description_Activity;
import com.healthcare.app.R;
import com.healthcare.app.Response.Subcategorydatum;
import com.healthcare.app.Utility.PreferenceUtils;

import java.util.ArrayList;
import java.util.List;

public class Fav_Adapter extends RecyclerView.Adapter<Fav_Adapter.ViewHolder> {


    Context context;
    List<Subcategorydatum> subcategorydata;
    String image_path="https://apkconnectlab.com/healthcareapp/";


    public Fav_Adapter(Context context, List<Subcategorydatum> subcategorydata){
        this.context=context;
        this.subcategorydata=subcategorydata;

    }


    @Override
    public Fav_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_favorite,parent,false);
        return new Fav_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Fav_Adapter.ViewHolder holder, int position) {

        Glide.with(context).load(image_path+subcategorydata.get(position).getHomesolutionsImage()).into(holder.cat_img);
        holder.name.setText(subcategorydata.get(position).getSubCategoryName());

        holder.card_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, Description_Activity.class);
                PreferenceUtils.setStringValue(context,PreferenceUtils.Sub_Cat_id,String.valueOf(subcategorydata.get(position).getSubCategoryId()));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return subcategorydata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView cat_img;
        TextView name;
        CardView card_type;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cat_img=itemView.findViewById(R.id.cat_img);
            name=itemView.findViewById(R.id.name);
            card_type=itemView.findViewById(R.id.card_type);

        }
    }


}


