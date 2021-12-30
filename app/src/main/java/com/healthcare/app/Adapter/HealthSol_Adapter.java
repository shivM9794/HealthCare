package com.healthcare.app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;
import com.healthcare.app.HealthSolutions.Health_Sol_Type;
import com.healthcare.app.R;
import com.healthcare.app.Response.Categorydatum;
import com.healthcare.app.Utility.PreferenceUtils;

import java.util.ArrayList;
import java.util.List;

public class HealthSol_Adapter extends RecyclerView.Adapter<HealthSol_Adapter.ViewHolder> {


    Context context;
    List<Categorydatum> categorydatum;
    String image_path="https://apkconnectlab.com/healthcareapp/";

    public HealthSol_Adapter(Context context, List<Categorydatum> categorydatum){
        this.context=context;
        this.categorydatum=categorydatum;

    }


    @Override
    public HealthSol_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_healthsol,parent,false);
        return new HealthSol_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HealthSol_Adapter.ViewHolder holder, int position) {

        Glide.with(context).load(image_path+categorydatum.get(position).getCategoryAppImage()).into(holder.image_health);
        holder.txt_health.setText(categorydatum.get(position).getCategoryName());

        holder.card_health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, Health_Sol_Type.class);
                PreferenceUtils.setStringValue(context,PreferenceUtils.Cat_id, String.valueOf(categorydatum.get(position).getCategoryId()));
                intent.putExtra("cat_name",categorydatum.get(position).getCategoryName());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return categorydatum.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

       ImageView image_health;
       TextView txt_health;
        MaterialCardView card_health;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image_health=itemView.findViewById(R.id.image_health);
            txt_health=itemView.findViewById(R.id.txt_health);
            card_health=itemView.findViewById(R.id.card_health);

        }
    }


}
