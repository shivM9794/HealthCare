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
import com.healthcare.app.Response.ShopcartDatum;
import com.healthcare.app.Response.Shopsubcategorydatum;

import java.util.List;

public class Shop_Cart_Adapter extends RecyclerView.Adapter<Shop_Cart_Adapter.ViewHolder> {


    Context context;
    List<Shopsubcategorydatum> shopsubcategorydata;
    String image_path="https://apkconnectlab.com/healthcareapp/";

    public Shop_Cart_Adapter(Context context,  List<Shopsubcategorydatum> shopsubcategorydata){
        this.context=context;
        this.shopsubcategorydata=shopsubcategorydata;

    }


    @Override
    public Shop_Cart_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_healthsupp,parent,false);
        return new Shop_Cart_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Shop_Cart_Adapter.ViewHolder holder, int position) {

        Glide.with(context).load(image_path+shopsubcategorydata.get(position).getShopCatImage()).into(holder.cat_img);
        holder.card_med.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, Supplement_Description.class);
                intent.putExtra("sub_catid",String.valueOf(shopsubcategorydata.get(position).getShopSubCategoryId()));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        holder.tab_name.setText(shopsubcategorydata.get(position).getShopSubCategoryName());
        holder.ruppes.setText("₹"+shopsubcategorydata.get(position).getShopPrice());
        holder.relief.setText(shopsubcategorydata.get(position).getShopText());

    }


    @Override
    public int getItemCount() {
        return shopsubcategorydata.size();
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
