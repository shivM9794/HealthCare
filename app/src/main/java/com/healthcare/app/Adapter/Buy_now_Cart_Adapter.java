package com.healthcare.app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.healthcare.app.R;
import com.healthcare.app.Response.CartDatum;
import com.healthcare.app.Response.Example;
import com.healthcare.app.Response.MycartDatum;
import com.healthcare.app.Response.Result;
import com.healthcare.app.Utility.ApiService;
import com.healthcare.app.Utility.PreferenceUtils;
import com.healthcare.app.ViewModel.DataViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Buy_now_Cart_Adapter extends RecyclerView.Adapter<Buy_now_Cart_Adapter.ViewHolder> {


    Context context;
    String quantity;
    String product_id;
    OnquantListener onquantListener;
    OnclickListener onclickListener;
    List<CartDatum> cartDatum;
    String image_path="https://apkconnectlab.com/healthcareapp/";


    public Buy_now_Cart_Adapter(Context context,List<CartDatum> cartDatum,OnclickListener onclickListener,OnquantListener OnquantListener){
        this.context=context;
        this.cartDatum=cartDatum;
        this.onclickListener=onclickListener;
        this.onquantListener=OnquantListener;

    }


    @Override
    public Buy_now_Cart_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_add_cart,parent,false);
        return new Buy_now_Cart_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Buy_now_Cart_Adapter.ViewHolder holder, int position) {

        Glide.with(context).load(image_path+cartDatum.get(position).getProdImage()).into(holder.img_med);
        holder.med_name.setText(cartDatum.get(position).getProductName());
        holder.relief.setText(cartDatum.get(position).getShopText());
        product_id= String.valueOf(cartDatum.get(position).getProductId());
        holder.amt.setText("Amount: ₹"+cartDatum.get(position).getProductPrice());

        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclickListener.onClick(String.valueOf(cartDatum.get(position).getProductId()));
            }
        });


        ArrayList<String> quantity_list = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            quantity_list.add(String.valueOf(i));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, R.layout.spinner_list_item, quantity_list);
        holder.quantity_dropdown.setAdapter(adapter);
        holder.quantity_dropdown.setText(adapter.getItem(0), false);


        quantity = quantity_list.get(0);

        get_quantity();

        holder.quantity_dropdown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                quantity = quantity_list.get(position);
                get_quantity();
            }
        });

    }

    private void get_quantity() {

        //Toast.makeText(context,PreferenceUtils.getStringValue(context,PreferenceUtils.Order_id),Toast.LENGTH_SHORT).show();

        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);

        HashMap<String, String> params = new HashMap<>();

        params.put("users_id",PreferenceUtils.getStringValue(context,PreferenceUtils.Userid));
        params.put("order_id", PreferenceUtils.getStringValue(context,PreferenceUtils.Orderid));
        params.put("product_id",product_id);
        params.put("quantity",quantity);


        Call<Example> call = apiService.createFactoryApi().get_quantity(headerMap, params);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("quantity", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {

                    //Toast.makeText(context,response.body().getMessage(),Toast.LENGTH_SHORT).show();

                }
            }


            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                // hideLoader();
                // showSnackbar();
                Log.e("quantity", " - > Error    " + t.getMessage());
            }
        });



    }


    @Override
    public int getItemCount() {
        return cartDatum.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        ImageView img_med;
        TextView med_name,relief,amt,remove;
        AutoCompleteTextView quantity_dropdown;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img_med=itemView.findViewById(R.id.img_med);
            med_name=itemView.findViewById(R.id.med_name);
            relief=itemView.findViewById(R.id.relief);
            amt=itemView.findViewById(R.id.amt);
            remove=itemView.findViewById(R.id.remove);
            quantity_dropdown=itemView.findViewById(R.id.quantity_dropdown);

        }
    }

    public interface OnclickListener{

        public void onClick(String prop_id);

    }

    public interface OnquantListener{

        public void onClick(String prop_id);

    }

}
