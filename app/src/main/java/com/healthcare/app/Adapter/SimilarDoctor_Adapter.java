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
import com.healthcare.app.Doctors.DoctorsList_Activity;
import com.healthcare.app.Hospitals.HospitalList_Activity;
import com.healthcare.app.R;
import com.healthcare.app.Response.SimilarDoctorDatum;

import java.util.List;

public class SimilarDoctor_Adapter extends RecyclerView.Adapter<SimilarDoctor_Adapter.ViewHolder> {


    Context context;
    List<SimilarDoctorDatum> similarDoctorData;
    String image_path="https://apkconnectlab.com/healthcareapp/";

    public SimilarDoctor_Adapter(Context context, List<SimilarDoctorDatum> similarDoctorData){
        this.context=context;
        this.similarDoctorData=similarDoctorData;

    }


    @Override
    public SimilarDoctor_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_toprated,parent,false);
        return new SimilarDoctor_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimilarDoctor_Adapter.ViewHolder holder, int position) {

        Glide.with(context).load(image_path+similarDoctorData.get(position).getDocImage()).into(holder.cat_img);
        holder.name.setText(similarDoctorData.get(position).getDoctorName());
        holder.rating.setRating(similarDoctorData.get(position).getRating());
        holder.cat_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, DoctorsList_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return  similarDoctorData.size();
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
