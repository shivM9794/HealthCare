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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.healthcare.app.Description.Supplement_Description;
import com.healthcare.app.R;
import com.healthcare.app.Response.ShopcartDatum;
import com.healthcare.app.Response.Shopsubcategorydatum;

import java.util.List;

public class Shopping_Adapter extends RecyclerView.Adapter<Shopping_Adapter.ViewHolder> {


    Context context;
    List<ShopcartDatum> shopcartData;
    String image_path="https://apkconnectlab.com/healthcareapp/";

    public Shopping_Adapter(Context context,  List<ShopcartDatum> shopcartData){
        this.context=context;
        this.shopcartData=shopcartData;

    }


    @Override
    public Shopping_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_shop_cart,parent,false);
        return new Shopping_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Shopping_Adapter.ViewHolder holder, int position) {

        holder.txt_heading.setText(shopcartData.get(position).getCategoryName());

        List<Shopsubcategorydatum> shopsubcategorydata=shopcartData.get(position).getShopsubcategorydata();

        Shop_Cart_Adapter shop_cart_adapter=new Shop_Cart_Adapter(context,shopsubcategorydata);
        holder.rec_cart.setAdapter(shop_cart_adapter);

    }


    @Override
    public int getItemCount() {
        return shopcartData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView txt_heading;
        RecyclerView rec_cart;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_heading=itemView.findViewById(R.id.txt_heading);
            rec_cart=itemView.findViewById(R.id.rec_cart);
            rec_cart.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));


        }
    }

}
