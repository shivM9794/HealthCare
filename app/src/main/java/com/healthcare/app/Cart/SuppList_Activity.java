package com.healthcare.app.Cart;

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
import com.healthcare.app.Adapter.Supp_List_Adapter;
import com.healthcare.app.Doctors.DoctorsList_Activity;
import com.healthcare.app.R;
import com.healthcare.app.Response.Doctordatum;
import com.healthcare.app.Response.ProdListDatum;
import com.healthcare.app.Response.Result;
import com.healthcare.app.ViewModel.DataViewModel;

import java.util.List;

public class SuppList_Activity extends AppCompatActivity {

    RecyclerView rec_supp_list;
    ImageView back;
    private ProgressDialog progress;
    DataViewModel dataViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supp_list);

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        back=findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        rec_supp_list=findViewById(R.id.rec_supp_list);
        rec_supp_list.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));

        rec_supp_list();
    }

    private void rec_supp_list() {

        showprogressbar(true);

        dataViewModel.sup_list(this).observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result results) {
                //hideLoader();
                if (results != null) {

                    List<ProdListDatum> prodListData = results.getProdListData();

                    showprogressbar(false);

                    if(prodListData.size()>0) {
                        Supp_List_Adapter supp_list_adapter = new Supp_List_Adapter(getApplicationContext(), prodListData);
                        rec_supp_list.setAdapter(supp_list_adapter);
                    }
                }
            }
        });


    }

    private void showprogressbar(Boolean IS_SHOW) {
        if (IS_SHOW) {
            progress = ProgressDialog.show(SuppList_Activity.this, "", "");
            progress.setContentView(R.layout.loader);
            progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        } else {
            progress.dismiss();
        }
    }

}
