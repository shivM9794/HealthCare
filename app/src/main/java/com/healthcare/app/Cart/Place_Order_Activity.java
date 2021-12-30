package com.healthcare.app.Cart;

import android.app.ProgressDialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.healthcare.app.Adapter.Add_Cart_Adapter;
import com.healthcare.app.Description.Supplement_Description;
import com.healthcare.app.Payment.Payment_activity;
import com.healthcare.app.Profile.ProfileActivity;
import com.healthcare.app.R;
import com.healthcare.app.Response.AddtocartData;
import com.healthcare.app.Response.FinalorderplaceData;
import com.healthcare.app.Response.ProductData;
import com.healthcare.app.Response.Result;
import com.healthcare.app.Response.UserData;
import com.healthcare.app.Utility.PreferenceUtils;
import com.healthcare.app.ViewModel.DataViewModel;

public class Place_Order_Activity extends AppCompatActivity {

    RecyclerView rec_cart;
    ImageView back,img_med;
    String order_id;
    ConstraintLayout constraint;
    TextView med_name,relief,card_amount,amount,total_amt,gst,paid,amt,change,address,name;
    private ProgressDialog progress;
    String image_path="https://apkconnectlab.com/healthcareapp/";
    DataViewModel dataViewModel;
    String prod_id="";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_order_activity);

        prod_id=getIntent().getStringExtra("prod_id");

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        initviews();

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

        get_cart_list();




    }

    private void initviews() {

        back=findViewById(R.id.back);
        img_med=findViewById(R.id.img_med);
        med_name=findViewById(R.id.med_name);
        relief=findViewById(R.id.relief);
        card_amount=findViewById(R.id.card_amount);
        change=findViewById(R.id.change);
        amount=findViewById(R.id.amount);
        total_amt=findViewById(R.id.total_amt);
        gst=findViewById(R.id.gst);
        paid=findViewById(R.id.paid);
        amt=findViewById(R.id.amt);
        address=findViewById(R.id.address);
        name=findViewById(R.id.name);

        constraint=findViewById(R.id.constraint);


    }

    private void get_cart_list() {

        showprogressbar(true);

        dataViewModel.buy_now(this, prod_id).observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result results) {
                //hideLoader();
                if (results != null) {



                    ProductData productData = results.getProductData();


                        Glide.with(getApplicationContext()).load(image_path + productData.getShopCatImage()).into(img_med);

                        med_name.setText(productData.getShopSubCategoryName());
                        relief.setText(productData.getShopText());
                        card_amount.setText("Amount: ₹" + productData.getShopPrice());

                        FinalorderplaceData finalorderplaceData = results.getFinalorderplaceData();

                        order_id = String.valueOf(finalorderplaceData.getOrderId());

                        PreferenceUtils.setStringValue(getApplicationContext(), PreferenceUtils.Order_id, order_id);

                        UserData userData = results.getUserData();

                        address.setText(userData.getUsersAddress());
                        name.setText(userData.getUsersName());

                        amount.setText("₹" + productData.getShopPrice());
                        total_amt.setText("₹" + productData.getShopPrice());
                        Integer gst_amt = ((productData.getShopPrice() * 18) / 100);
                        gst.setText("₹" + String.valueOf(gst_amt));
                        paid.setText(String.valueOf(productData.getShopPrice() + gst_amt));
                        amt.setText(String.valueOf(productData.getShopPrice() + gst_amt));

                    showprogressbar(false);
                    }
                else{
                    showprogressbar(false);
                }

                }

        });
    }

        private void showprogressbar(Boolean IS_SHOW) {
            if (IS_SHOW) {
                progress = ProgressDialog.show(Place_Order_Activity.this, "", "");
                progress.setContentView(R.layout.loader);
                progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            } else {
                progress.dismiss();
            }
        }





    public void btn_pay(View view) {

        Intent intent=new Intent(getApplicationContext(), Payment_activity.class);
        startActivity(intent);

    }

    @Override
    protected void onStart() {
        super.onStart();

       // get_cart_list();

    }
}
