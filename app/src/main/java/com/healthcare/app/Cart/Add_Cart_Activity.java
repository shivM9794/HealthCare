package com.healthcare.app.Cart;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.healthcare.app.Adapter.Add_Cart_Adapter;
import com.healthcare.app.DashBoard.DashBoard_Activity;
import com.healthcare.app.Description.Supplement_Description;
import com.healthcare.app.R;
import com.healthcare.app.Response.AddtocartData;
import com.healthcare.app.Response.MycartDatum;
import com.healthcare.app.Response.Result;
import com.healthcare.app.ViewModel.DataViewModel;

import java.util.List;

public class Add_Cart_Activity extends AppCompatActivity implements Add_Cart_Adapter.OnclickListener{

    RecyclerView rec_add_cart;
    ImageView back;
    CardView card_details;
    private ProgressDialog progress;
    DataViewModel dataViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_cart_activity);

        back=findViewById(R.id.back);
        card_details=findViewById(R.id.card_details);

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        rec_add_cart=findViewById(R.id.rec_add_cart);
        rec_add_cart.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        get_cart_list();
    }

    private void get_cart_list() {

        showprogressbar(true);

        dataViewModel.get_cart(this).observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result results) {
                //hideLoader();
                if (results != null) {

                    List<MycartDatum> mycartDatumList=results.getMycartData();

                    if(mycartDatumList.size()>0) {

                        showprogressbar(false);
                        card_details.setVisibility(View.VISIBLE);

                        Add_Cart_Adapter add_cart_adapter = new Add_Cart_Adapter(getApplicationContext(), mycartDatumList,Add_Cart_Activity.this);
                        rec_add_cart.setAdapter(add_cart_adapter);
                    }

                    else{
                        showprogressbar(false);
                        card_details.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(), "No Data Found", Toast.LENGTH_SHORT).show();

                    }

                }
            }
        });

    }

    public void place_order(View view) {
        Intent intent=new Intent(getApplicationContext(),PlaceOrder_ViaCart.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void showprogressbar(Boolean IS_SHOW) {
        if (IS_SHOW) {
            progress = ProgressDialog.show(Add_Cart_Activity.this, "", "");
            progress.setContentView(R.layout.loader);
            progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        } else {
            progress.dismiss();
        }
    }


    @Override
    public void onClick(String prop_id) {

        dataViewModel.add_cart(this, prop_id).observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result results) {
                //hideLoader();
                if (results != null) {

                    AddtocartData addtocartData = results.getAddtocartData();


                }
            }
        });
    }

    public void con_shop(View view) {

        Intent intent=new Intent(getApplicationContext(), DashBoard_Activity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }
}
