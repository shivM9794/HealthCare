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
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.healthcare.app.Doctors.DoctorsList_Activity;
import com.healthcare.app.Doctors.Doctors_Description;
import com.healthcare.app.R;
import com.healthcare.app.Response.Doctordatum;

import java.util.ArrayList;
import java.util.List;

public class DoctorsList_Adapter extends RecyclerView.Adapter<DoctorsList_Adapter.ViewHolder> {


    Context context;
    List<Doctordatum> doctordata;
    String image_path="https://apkconnectlab.com/healthcareapp/";

    public DoctorsList_Adapter(Context context, List<Doctordatum> doctordata){
        this.context=context;
        this.doctordata=doctordata;

    }


    @Override
    public DoctorsList_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_exp_doc,parent,false);
        return new DoctorsList_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorsList_Adapter.ViewHolder holder, int position) {

        Glide.with(context).load(image_path+doctordata.get(position).getDocImage()).into(holder.cat_img);
        holder.name.setText(doctordata.get(position).getDoctorName());
        holder.rating.setRating(Float.parseFloat(doctordata.get(position).getRating()));
        holder.specialist.setText(doctordata.get(position).getSpecialist());
        holder.fees.setText("Fees: ₹"+String.valueOf(doctordata.get(position).getDocFees()));
        holder.card_doctorlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, Doctors_Description.class);
                intent.putExtra("doc_id",String.valueOf(doctordata.get(position).getDoctorId()));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return doctordata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView cat_img;
        CardView card_doctorlist;
        RatingBar rating;
        TextView name,specialist,fees;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cat_img=itemView.findViewById(R.id.cat_img);
            card_doctorlist=itemView.findViewById(R.id.card_doctorlist);
            rating=itemView.findViewById(R.id.rating);
            name=itemView.findViewById(R.id.name);
            specialist=itemView.findViewById(R.id.specialist);
            fees=itemView.findViewById(R.id.fees);

        }
    }


}

