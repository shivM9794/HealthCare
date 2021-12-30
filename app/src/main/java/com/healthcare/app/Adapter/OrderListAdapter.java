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
import com.healthcare.app.Response.Myorder;

import java.util.ArrayList;
import java.util.List;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.ViewHolder> {


    Context context;
    List<Myorder> orderplaceDataList;
    String image_path="https://apkconnectlab.com/healthcareapp/";

    public OrderListAdapter(Context context, List<Myorder> orderplaceDataList){
        this.context=context;
        this.orderplaceDataList=orderplaceDataList;

    }


    @Override
    public OrderListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_order,parent,false);
        return new OrderListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderListAdapter.ViewHolder holder, int position) {

        Glide.with(context).load(image_path+orderplaceDataList.get(position).getShopCatImage()).into(holder.img_med);
        holder.med_name.setText(orderplaceDataList.get(position).getShopSubCategoryName());
        holder.relief.setText(orderplaceDataList.get(position).getShopText());
        holder.amt.setText("Amount: ₹"+orderplaceDataList.get(position).getShopPrice());
        holder.quantity_txt.setText(String.valueOf(orderplaceDataList.get(position).getQuantity()));


    }


    @Override
    public int getItemCount() {
        return orderplaceDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView img_med;
        TextView med_name,relief,amt,quantity_txt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img_med=itemView.findViewById(R.id.img_med);
            med_name=itemView.findViewById(R.id.med_name);
            relief=itemView.findViewById(R.id.relief);
            amt=itemView.findViewById(R.id.amt);
            quantity_txt=itemView.findViewById(R.id.quantity_txt);

        }
    }

}
