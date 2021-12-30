package com.healthcare.app.Doctors;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.healthcare.app.R;
import com.healthcare.app.Response.AppointmentDetails;
import com.healthcare.app.Response.DoctorDatadetails;
import com.healthcare.app.Response.RatingData;
import com.healthcare.app.Response.Result;
import com.healthcare.app.Response.SimilarDoctorDatum;
import com.healthcare.app.Adapter.SimilarDoctor_Adapter;
import com.healthcare.app.ViewModel.DataViewModel;

import java.util.Calendar;
import java.util.List;

public class Doctors_Description extends AppCompatActivity {

    TextView description, name, specialist, fees,rate_now,txt_title;
    ImageView back;
    RatingBar rating;
    Dialog dialog;
    String date,time;
    int mYear, mMonth, mDay, mHour, mMinute,sec;
    String doc_id = "",fee="";
    DataViewModel dataViewModel;
    private ProgressDialog progress;
    RecyclerView rec_others_doctors;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctors_des);

        initviews();

        doc_id = getIntent().getStringExtra("doc_id");

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

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
                        dialog.dismiss();
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

        get_others_list();
    }

    private void sub_rating(Float ratings) {

        dataViewModel.sub_rating(this, doc_id,ratings).observe(this, new Observer<Result>() {
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
        name = findViewById(R.id.name);
        specialist = findViewById(R.id.specialist);
        fees = findViewById(R.id.fees);
        dialog=new Dialog(Doctors_Description.this);
        rating = findViewById(R.id.rating);
        back = findViewById(R.id.back);
        txt_title=findViewById(R.id.txt_title);
        rate_now=findViewById(R.id.rate_now);
        description = findViewById(R.id.description);
        rec_others_doctors = findViewById(R.id.rec_others_doctors);
        rec_others_doctors.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

    }

    private void get_others_list() {

        showprogressbar(true);

        dataViewModel.doc_des(this, doc_id).observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result results) {
                //hideLoader();
                if (results != null) {

                    DoctorDatadetails doctorDatadetails = results.getDoctorDatadetails();
                    txt_title.setText(doctorDatadetails.getDoctorName());
                    description.setText(doctorDatadetails.getDescription());
                    rating.setRating(doctorDatadetails.getRating());
                    specialist.setText(doctorDatadetails.getSpecialist());
                    name.setText(doctorDatadetails.getDoctorName());
                    fee=String.valueOf(doctorDatadetails.getDocFees());
                    fees.setText("Fees: ₹" + String.valueOf(doctorDatadetails.getDocFees()));

                    if(doctorDatadetails.getIsRated().equalsIgnoreCase("Y")){
                        rate_now.setVisibility(View.GONE);
                    }
                    else{
                        rate_now.setVisibility(View.VISIBLE);
                    }

                    showprogressbar(false);

                    List<SimilarDoctorDatum> similarDoctorData = results.getSimilarDoctorData();


                    if (similarDoctorData.size() > 0) {
                        SimilarDoctor_Adapter similarDoctor_adapter = new SimilarDoctor_Adapter(getApplicationContext(), similarDoctorData);
                        rec_others_doctors.setAdapter(similarDoctor_adapter);
                    } else {
                        showprogressbar(false);
                    }
                } else {
                    showprogressbar(false);
                }
            }
        });

    }

    private void showprogressbar(Boolean IS_SHOW) {
        if (IS_SHOW) {
            progress = ProgressDialog.show(Doctors_Description.this, "", "");
            progress.setContentView(R.layout.loader);
            progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        } else {
            progress.dismiss();
        }
    }

    public void book_appointment(View view) {

        dialog.setContentView(R.layout.book_app);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        TextInputEditText select_date=dialog.findViewById(R.id.select_date);
        select_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(Doctors_Description.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                select_date.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                                date=select_date.getText().toString();

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();

            }
        });
        TextInputEditText select_time=dialog.findViewById(R.id.select_time);
        select_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);
                // sec=c.get(Calendar.SECOND);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(Doctors_Description.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                select_time.setText(hourOfDay + ":" + minute);
                                time=select_time.getText().toString();
                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();

            }
        });
        Button btn_sub=dialog.findViewById(R.id.btn_sub);
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float ratings=rating.getRating();
                add_app(date,time);
                dialog.dismiss();
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

    private void add_app(String date, String time) {

        dataViewModel.book_app(this, doc_id,fee,date,time).observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result results) {
                //hideLoader();
                if (results != null) {

                    AppointmentDetails appointmentDetails = results.getAppointmentDetails();


                }
            }
        });

    }




}
