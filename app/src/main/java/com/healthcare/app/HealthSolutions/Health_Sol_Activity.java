package com.healthcare.app.HealthSolutions;

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

import com.healthcare.app.Adapter.HealthSol_Adapter;
import com.healthcare.app.R;
import com.healthcare.app.Response.Categorydatum;
import com.healthcare.app.Response.Result;
import com.healthcare.app.ViewModel.DataViewModel;

import java.util.ArrayList;
import java.util.List;

public class Health_Sol_Activity extends AppCompatActivity {

    RecyclerView rec_health_sol;
    ImageView back;
    HealthSol_Adapter healthSol_adapter;
    private ProgressDialog progress;
    DataViewModel dataViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_sol);

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        rec_health_sol=findViewById(R.id.rec_health_sol);
        rec_health_sol.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));

        back=findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        get_heal_sol_list();

    }

    private void get_heal_sol_list() {

        showprogressbar(true);

        dataViewModel.view_all(this).observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result results) {
                //hideLoader();
                if (results != null) {

                    List<Categorydatum> categorydatum = results.getCategorydata();

                    showprogressbar(false);

                    if (categorydatum.size() > 0) {
                        healthSol_adapter=new HealthSol_Adapter(getApplicationContext(),categorydatum);
                          rec_health_sol.setAdapter(healthSol_adapter);
                    }


                }
            }
        });
    }

    private void showprogressbar(Boolean IS_SHOW) {
        if (IS_SHOW) {
            progress = ProgressDialog.show(Health_Sol_Activity.this, "", "");
            progress.setContentView(R.layout.loader);
            progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        } else {
            progress.dismiss();
        }
    }
}
