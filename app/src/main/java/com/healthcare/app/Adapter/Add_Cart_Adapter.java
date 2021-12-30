package com.healthcare.app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputLayout;
import com.healthcare.app.R;
import com.healthcare.app.Response.MycartDatum;

import java.util.ArrayList;
import java.util.List;

public class Add_Cart_Adapter extends RecyclerView.Adapter<Add_Cart_Adapter.ViewHolder> {


    Context context;
    String quantity;
    OnclickListener onclickListener;
    List<MycartDatum> mycartDatumList;
    String image_path="https://apkconnectlab.com/healthcareapp/";


    public Add_Cart_Adapter(Context context, List<MycartDatum> mycartDatumList, OnclickListener onclickListener){
        this.context=context;
        this.mycartDatumList=mycartDatumList;
        this.onclickListener=onclickListener;

    }


    @Override
    public Add_Cart_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_add_cart,parent,false);
        return new Add_Cart_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Add_Cart_Adapter.ViewHolder holder, int position) {

        Glide.with(context).load(image_path+mycartDatumList.get(position).getShopCatImage()).into(holder.img_med);
        holder.med_name.setText(mycartDatumList.get(position).getShopSubCategoryName());
        holder.relief.setText(mycartDatumList.get(position).getShopText());
        holder.amt.setText("Amount: ₹"+mycartDatumList.get(position).getShopPrice());

        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclickListener.onClick(String.valueOf(mycartDatumList.get(position).getProductId()));
            }
        });

    }


    @Override
    public int getItemCount() {
        return mycartDatumList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        ImageView img_med;
        TextView med_name,relief,amt,quantity,remove;
        AutoCompleteTextView quantity_dropdown;
        TextInputLayout quantity_txt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img_med=itemView.findViewById(R.id.img_med);
            med_name=itemView.findViewById(R.id.med_name);
            relief=itemView.findViewById(R.id.relief);
            quantity=itemView.findViewById(R.id.quantity);
            amt=itemView.findViewById(R.id.amt);
            quantity_txt=itemView.findViewById(R.id.quantity_txt);
            remove=itemView.findViewById(R.id.remove);
            quantity_dropdown=itemView.findViewById(R.id.quantity_dropdown);
            quantity.setVisibility(View.GONE);
            quantity_dropdown.setVisibility(View.GONE);
            quantity_txt.setVisibility(View.GONE);

        }
    }

    public interface OnclickListener{

        public void onClick(String prop_id);

    }
}

