package com.healthcare.app.Doctors;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.healthcare.app.Adapter.DoctorsList_Adapter;
import com.healthcare.app.Adapter.Experienced_Adapter;
import com.healthcare.app.Adapter.HospitalList_Adapter;
import com.healthcare.app.Hospitals.HospitalList_Activity;
import com.healthcare.app.R;
import com.healthcare.app.Response.Doctordatum;
import com.healthcare.app.Response.HospitalDatum;
import com.healthcare.app.Response.Result;
import com.healthcare.app.ViewModel.DataViewModel;

import java.util.ArrayList;
import java.util.List;

public class DoctorsList_Activity extends AppCompatActivity {

    RecyclerView rec_doctors_list;
    ImageView back;
    private ProgressDialog progress;
    DataViewModel dataViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_list);

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        back=findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        rec_doctors_list=findViewById(R.id.rec_doctors_list);
        rec_doctors_list.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));

        get_doctors_list();
    }

    private void get_doctors_list() {

        showprogressbar(true);

        dataViewModel.doc_list(this).observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result results) {
                //hideLoader();
                if (results != null) {

                    List<Doctordatum> doctordata = results.getDoctordata();

                    showprogressbar(false);

                    if(doctordata.size()>0) {
                        DoctorsList_Adapter doctorsList_adapter = new DoctorsList_Adapter(getApplicationContext(), doctordata);
                        rec_doctors_list.setAdapter(doctorsList_adapter);
                    }
                }
            }
        });


    }

    private void showprogressbar(Boolean IS_SHOW) {
        if (IS_SHOW) {
            progress = ProgressDialog.show(DoctorsList_Activity.this, "", "");
            progress.setContentView(R.layout.loader);
            progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        } else {
            progress.dismiss();
        }
    }

}
