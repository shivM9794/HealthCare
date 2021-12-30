package com.healthcare.app.Hospitals;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.healthcare.app.R;
import com.healthcare.app.Response.HospitalDatadetails;
import com.healthcare.app.Response.RatingData;
import com.healthcare.app.Response.Result;
import com.healthcare.app.Response.SimilarhospitalDatum;
import com.healthcare.app.Adapter.Similarhospital_Adapter;
import com.healthcare.app.ViewModel.DataViewModel;

import java.util.List;

public class Hospital_Description extends AppCompatActivity {

    RecyclerView rec_others_hospital;
    TextView description,address,no,hos_name,rate_now,txt_title;
    ImageView back;
    RatingBar rating;
    Dialog dialog;
    String hosp_id;
    DataViewModel dataViewModel;
    private ProgressDialog progress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hosp_des);

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        initviews();

        rate_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.setContentView(R.layout.rating);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                RatingBar rating=dialog.findViewById(R.id.rating);
                Button btn_sub=dialog.findViewById(R.id.btn_sub);
                btn_sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Float ratings=rating.getRating();
                        sub_rating(ratings);
                    }
                });
                ImageView cancel=dialog.findViewById(R.id.cancel);
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        hosp_id=getIntent().getStringExtra("hosp_id");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        rec_others_hospital.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));

        get_hospitallist();
    }

    private void sub_rating(Float ratings) {

        dataViewModel.hos_sub_rating(this, hosp_id,ratings).observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result results) {
                //hideLoader();
                if (results != null) {

                    RatingData ratingData = results.getRatingData();


                }
            }
        });

    }

    private void initviews() {
        back=findViewById(R.id.back);
        description=findViewById(R.id.description);
        rec_others_hospital=findViewById(R.id.rec_others_hospital);
        address=findViewById(R.id.address);
        no=findViewById(R.id.no);
        txt_title=findViewById(R.id.txt_title);
        dialog=new Dialog(Hospital_Description.this);
        rate_now=findViewById(R.id.rate_now);
        hos_name=findViewById(R.id.hos_name);
        rating=findViewById(R.id.rating);
    }

    private void get_hospitallist() {
        showprogressbar(true);

        dataViewModel.hos_des(this,hosp_id).observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result results) {
                //hideLoader();
                if (results != null) {

                    HospitalDatadetails hospital_description=results.getHospitalDatadetails();
                    txt_title.setText(hospital_description.getHospitalName());
                    description.setText(hospital_description.getDescription());
                    rating.setRating(hospital_description.getRating());
                    hos_name.setText(hospital_description.getHospitalName());
                    address.setText(hospital_description.getAddress());
                    no.setText(String.valueOf(hospital_description.getPhone()));

                    showprogressbar(false);

                    List<SimilarhospitalDatum> similarhospitalData=results.getSimilarhospitalData();


                    if(similarhospitalData.size() > 0) {
                        Similarhospital_Adapter similarhospital_adapter=new Similarhospital_Adapter(getApplicationContext(),similarhospitalData);
                         rec_others_hospital.setAdapter(similarhospital_adapter);
                    }
                    else{
                        showprogressbar(false);
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
            progress = ProgressDialog.show(Hospital_Description.this, "", "");
            progress.setContentView(R.layout.loader);
            progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        } else {
            progress.dismiss();
        }
    }

}
