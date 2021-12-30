package com.healthcare.app.Description;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.healthcare.app.Adapter.HealthSupp_Adapter;
import com.healthcare.app.Adapter.Shopping_Adapter;
import com.healthcare.app.Adapter.Similar_Shopping_Adapter;
import com.healthcare.app.Cart.Add_Cart_Activity;
import com.healthcare.app.Cart.Place_Order_Activity;
import com.healthcare.app.R;
import com.healthcare.app.Response.AddtocartData;
import com.healthcare.app.Response.Result;
import com.healthcare.app.Response.ShopcartDatum;
import com.healthcare.app.Response.Shopsubcategorydatum;
import com.healthcare.app.Response.Shopsubcategorydetails;
import com.healthcare.app.Response.SimilarProductDatum;
import com.healthcare.app.ViewModel.DataViewModel;

import java.util.ArrayList;
import java.util.List;

public class Supplement_Description extends AppCompatActivity {

    RecyclerView rec_similar_prod;
    TextView description,med_name,med_relief,amount;
    ImageView back,image_view,cart;
    String prod_id;
    private ProgressDialog progress;
    DataViewModel dataViewModel;
    String sub_catid;
    String image_path="https://apkconnectlab.com/healthcareapp/";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.supp_des);

        back=findViewById(R.id.back);

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        initviews();

        sub_catid=getIntent().getStringExtra("sub_catid");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                add_cart();

            }
        });

        get_similarproducts_list();

    }

    private void add_cart() {


        dataViewModel.add_cart(this,prod_id).observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result results) {
                //hideLoader();
                if (results != null) {

                    AddtocartData addtocartData=results.getAddtocartData();

                }
            }
        });

    }

    private void initviews() {

        image_view=findViewById(R.id.image_view);
        description=findViewById(R.id.description);
        rec_similar_prod=findViewById(R.id.rec_similar_prod);
        rec_similar_prod.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
        med_name=findViewById(R.id.med_name);
        cart=findViewById(R.id.cart);
        med_relief=findViewById(R.id.med_relief);
        amount=findViewById(R.id.amount);

    }

    private void get_similarproducts_list() {

        showprogressbar(true);

        dataViewModel.shopp_cart_des(this,sub_catid).observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result results) {
                //hideLoader();
                if (results != null) {

                    Shopsubcategorydetails shopsubcategorydata = results.getShopsubcategorydetails();

                    description.setText(shopsubcategorydata.getShopDescription());
                    prod_id= String.valueOf(shopsubcategorydata.getShopSubCategoryId());
                    Glide.with(getApplicationContext()).load(image_path+shopsubcategorydata.getShopCatDetailImage()).into(image_view);
                    med_name.setText(shopsubcategorydata.getShopSubCategoryName());
                    med_relief.setText(shopsubcategorydata.getShopText());
                    amount.setText("Amount: ₹"+shopsubcategorydata.getShopPrice());

                    showprogressbar(false);

                    List<SimilarProductDatum> similarProductData=results.getSimilarProductData();

                    if(similarProductData.size()>0) {
                        Similar_Shopping_Adapter shopping_adapter=new Similar_Shopping_Adapter(getApplicationContext(),similarProductData);
                        rec_similar_prod.setAdapter(shopping_adapter);
                    }
                }
                else{
                    showprogressbar(false);
                }
            }
        });

    }

    private void showprogressbar(Boolean IS_SHOW) {
        if (IS_SHOW) {
            progress = ProgressDialog.show(Supplement_Description.this, "", "");
            progress.setContentView(R.layout.loader);
            progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        } else {
            progress.dismiss();
        }
    }

    public void buy_now(View view) {

                    Intent intent = new Intent(getApplicationContext(), Place_Order_Activity.class);
                    intent.putExtra("prod_id",prod_id);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);


    }
}
