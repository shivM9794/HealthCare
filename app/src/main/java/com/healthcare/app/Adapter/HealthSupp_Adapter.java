package com.healthcare.app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.healthcare.app.Description.Supplement_Description;
import com.healthcare.app.R;
import com.healthcare.app.Response.ProdDatum;

import java.util.ArrayList;
import java.util.List;

public class HealthSupp_Adapter extends RecyclerView.Adapter<HealthSupp_Adapter.ViewHolder> {


    Context context;
    List<ProdDatum> prodData;
    String image_path="https://apkconnectlab.com/healthcareapp/";

    public HealthSupp_Adapter(Context context,  List<ProdDatum> prodData){
        this.context=context;
        this.prodData=prodData;

    }


    @Override
    public HealthSupp_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_healthsupp,parent,false);
        return new HealthSupp_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HealthSupp_Adapter.ViewHolder holder, int position) {

        Glide.with(context).load(image_path+prodData.get(position).getShopCatImage()).into(holder.cat_img);
        holder.card_med.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, Supplement_Description.class);
                intent.putExtra("sub_catid",String.valueOf(prodData.get(position).getShopSubCategoryId()));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        holder.tab_name.setText(prodData.get(position).getShopSubCategoryName());
        holder.ruppes.setText("₹"+prodData.get(position).getShopPrice());
        holder.relief.setText(prodData.get(position).getShopText());

    }


    @Override
    public int getItemCount() {
        return prodData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView cat_img;
        CardView card_med;
        TextView tab_name,relief,ruppes;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cat_img=itemView.findViewById(R.id.cat_img);
            card_med=itemView.findViewById(R.id.card_med);
            tab_name=itemView.findViewById(R.id.tab_name);
            relief=itemView.findViewById(R.id.relief);
            ruppes=itemView.findViewById(R.id.ruppes);

        }
    }


}
