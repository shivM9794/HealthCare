package com.healthcare.app.Hospitals;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.healthcare.app.Adapter.HospitalList_Adapter;
import com.healthcare.app.Adapter.TopRated_Adapter;
import com.healthcare.app.R;
import com.healthcare.app.Response.Categorydatum;
import com.healthcare.app.Response.HospitalDatum;
import com.healthcare.app.Response.Result;
import com.healthcare.app.ViewModel.DataViewModel;

import java.util.ArrayList;
import java.util.List;

public class HospitalList_Activity extends AppCompatActivity {

    RecyclerView rec_hospital;
    ImageView back;
    private ProgressDialog progress;
    DataViewModel dataViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitallist);

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        back=findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        rec_hospital=findViewById(R.id.rec_hospital);
        rec_hospital.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));


        get_hospital_list();
    }

    private void get_hospital_list() {

        showprogressbar(true);
        dataViewModel.hosp_list(this).observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result results) {
                //hideLoader();
                if (results != null) {

                    List<HospitalDatum> hospitalData = results.getHospitalData();

                    showprogressbar(false);

                    HospitalList_Adapter hospitalList_adapter = new HospitalList_Adapter(getApplicationContext(), hospitalData);
                    rec_hospital.setAdapter(hospitalList_adapter);
                }
            }
        });
    }

    private void showprogressbar(Boolean IS_SHOW) {
        if (IS_SHOW) {
            progress = ProgressDialog.show(HospitalList_Activity.this, "", "");
            progress.setContentView(R.layout.loader);
            progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        } else {
            progress.dismiss();
        }
    }

}
