package com.healthcare.app.Cart;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.healthcare.app.Adapter.Add_Cart_Adapter;
import com.healthcare.app.Adapter.Buy_now_Cart_Adapter;
import com.healthcare.app.Payment.Payment_activity;
import com.healthcare.app.Profile.ProfileActivity;
import com.healthcare.app.R;
import com.healthcare.app.Response.AddtocartData;
import com.healthcare.app.Response.CartDatum;
import com.healthcare.app.Response.CartorderplaceDatum;
import com.healthcare.app.Response.CartuserData;
import com.healthcare.app.Response.Example;
import com.healthcare.app.Response.ProductData;
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

public class PlaceOrder_ViaCart extends AppCompatActivity implements Buy_now_Cart_Adapter.OnclickListener,Buy_now_Cart_Adapter.OnquantListener {

    RecyclerView rec_cart;
    ImageView back;
    TextView amount, total_amt, gst, paid, amt, name, txt_address,change;
    private ProgressDialog progress;
    String image_path = "https://apkconnectlab.com/healthcareapp/";
    DataViewModel dataViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_order_via_cart);

        initviews();

        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
            }
        });


        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        get_cartlist();

    }

    private void get_cartlist() {

        showprogressbar(true);

        dataViewModel.cart_buy_now(this).observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result results) {
                //hideLoader();
                if (results != null) {

                    showprogressbar(false);

                    List<CartDatum> cartDatum = results.getCartData();

                    CartuserData cartuserData = results.getCartuserData();

                    List<CartorderplaceDatum> cartorderplaceData = results.getCartorderplaceData();

                    PreferenceUtils.setStringValue(getApplicationContext(), PreferenceUtils.Orderid, String.valueOf(cartorderplaceData.get(0).getOrderId()));
                   // Toast.makeText(getApplicationContext(),PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.Orderid),Toast.LENGTH_SHORT).show();

                    name.setText(cartuserData.getUsersName());
                    txt_address.setText(cartuserData.getUsersAddress());

                    amount.setText("₹" + results.getTotal());
                    total_amt.setText("₹" + results.getTotal());
                    gst.setText("₹" + results.getGst());
                    paid.setText("₹" + results.getGst());
                    amt.setText("₹" + results.getFinalTotal());

                    Buy_now_Cart_Adapter add_cart_adapter = new Buy_now_Cart_Adapter(getApplicationContext(), cartDatum, PlaceOrder_ViaCart.this, PlaceOrder_ViaCart.this);
                    rec_cart.setAdapter(add_cart_adapter);

                }
            }
        });

    }

    private void initviews() {

        rec_cart = findViewById(R.id.rec_cart);
        rec_cart.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        back = findViewById(R.id.back);

        amount = findViewById(R.id.amount);
        total_amt = findViewById(R.id.total_amt);
        gst = findViewById(R.id.gst);
        paid = findViewById(R.id.paid);
        amt = findViewById(R.id.amt);
        change=findViewById(R.id.change);

        name = findViewById(R.id.name);
        txt_address = findViewById(R.id.txt_address);


    }

    private void showprogressbar(Boolean IS_SHOW) {
        if (IS_SHOW) {
            progress = ProgressDialog.show(PlaceOrder_ViaCart.this, "", "");
            progress.setContentView(R.layout.loader);
            progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        } else {
            progress.dismiss();
        }
    }

    public void btn_pay(View view) {

        Intent intent = new Intent(getApplicationContext(), Payment_activity.class);
        startActivity(intent);

    }

    @Override
    public void onClick(String prop_id) {

        dataViewModel.add_cart(this, prop_id).observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result results) {
                //hideLoader();
                if (results != null) {

                    AddtocartData addtocartData = results.getAddtocartData();

                    Intent intent=new Intent(getApplicationContext(),Add_Cart_Activity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);


                }
            }
        });

    }

    /*@Override
    public void onClickk(String product_id,String quantity) {

            Toast.makeText(getApplicationContext(),"gggg",Toast.LENGTH_SHORT).show();

            ApiService apiService = ApiService.getInstance();

            HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(getApplicationContext());

            HashMap<String, String> params = new HashMap<>();

            params.put("users_id",PreferenceUtils.getStringValue(getApplicationContext(),PreferenceUtils.Userid));
            params.put("order_id", PreferenceUtils.getStringValue(getApplicationContext(),PreferenceUtils.Order_id));
            params.put("product_id",product_id);
            params.put("quantity",quantity);


            Call<Example> call = apiService.createFactoryApi().get_quantity(headerMap, params);
            call.enqueue(new Callback<Example>() {
                @Override
                public void onResponse(Call<Example> call, Response<Example> response) {
                    Log.e("quantity", "Response: " + new Gson().toJson(response.body()));
                    if (response.body() != null) {

                        Toast.makeText(getApplicationContext(),response.body().getMessage(),Toast.LENGTH_SHORT).show();

                    }
                }


                @Override
                public void onFailure(Call<Example> call, Throwable t) {
                    // hideLoader();
                    // showSnackbar();
                    Log.e("quantity", " - > Error    " + t.getMessage());
                }
            });


        }*/


}
