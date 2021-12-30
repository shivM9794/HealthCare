package com.healthcare.app.Payment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.healthcare.app.Cart.Place_Order_Activity;
import com.healthcare.app.DashBoard.DashBoard_Activity;
import com.healthcare.app.R;
import com.healthcare.app.Response.Result;
import com.healthcare.app.ViewModel.DataViewModel;

public class Payment_activity extends AppCompatActivity {

    String payment_mode="";
    ImageView back;
    RadioButton radio_btn_cod,radio_btn_razor;
    private ProgressDialog progress;
    String image_path="https://apkconnectlab.com/healthcareapp/";
    DataViewModel dataViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        back=findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        radio_btn_cod=findViewById(R.id.radio_btn_cod);
        radio_btn_razor=findViewById(R.id.radio_btn_razor);

        radio_btn_razor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                payment_mode="COD";
            }
        });

    }

    public void pay_COD(View view) {

        payment_mode="COD";

    }

    public void btn_nxt(View view) {

       // showprogressbar(true);

        dataViewModel.place_order(this, payment_mode).observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result results) {
                //hideLoader();
                if (results != null) {

                    Intent intent=new Intent(getApplicationContext(), DashBoard_Activity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);

                }
            }
        });
    }

                private void showprogressbar(Boolean IS_SHOW) {
                    if (IS_SHOW) {
                        progress = ProgressDialog.show(Payment_activity.this, "", "");
                        progress.setContentView(R.layout.loader);
                        progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                    } else {
                        progress.dismiss();
                    }
                }

}
