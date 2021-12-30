package com.healthcare.app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.healthcare.app.Hospitals.HospitalList_Activity;
import com.healthcare.app.Hospitals.Hospital_Description;
import com.healthcare.app.R;
import com.healthcare.app.Response.HospitalDatum;

import java.util.ArrayList;
import java.util.List;

public class TopRated_Adapter extends RecyclerView.Adapter<TopRated_Adapter.ViewHolder> {


    Context context;
    List<HospitalDatum> hospitalData;
    String image_path="https://apkconnectlab.com/healthcareapp/";

    public TopRated_Adapter(Context context,   List<HospitalDatum> hospitalData){
        this.context=context;
        this.hospitalData=hospitalData;

    }


    @Override
    public TopRated_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_toprated,parent,false);
        return new TopRated_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopRated_Adapter.ViewHolder holder, int position) {

        Glide.with(context).load(image_path+hospitalData.get(position).getHospitalImage()).into(holder.cat_img);
        holder.name.setText(hospitalData.get(position).getHospitalName());
        holder.rating.setRating(Float.parseFloat(hospitalData.get(position).getRating()));
        holder.cat_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, Hospital_Description.class);
                intent.putExtra("hosp_id",String.valueOf(hospitalData.get(position).getHospitalId()));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return  hospitalData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView cat_img;
        RatingBar rating;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cat_img=itemView.findViewById(R.id.cat_img);
            name=itemView.findViewById(R.id.name);
            rating=itemView.findViewById(R.id.rating);

        }
    }


}

