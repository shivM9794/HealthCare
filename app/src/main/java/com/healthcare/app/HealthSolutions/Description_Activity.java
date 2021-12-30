package com.healthcare.app.HealthSolutions;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.healthcare.app.Adapter.About_Adapter;
import com.healthcare.app.Adapter.Description_Adapter;
import com.healthcare.app.Adapter.Fav_Adapter;
import com.healthcare.app.R;
import com.healthcare.app.Response.Result;
import com.healthcare.app.Response.SubCategoryType;
import com.healthcare.app.Response.Subcategorydatum;
import com.healthcare.app.Response.Subcategorydetails;
import com.healthcare.app.ViewModel.DataViewModel;

import java.util.ArrayList;
import java.util.List;

public class Description_Activity extends AppCompatActivity {

    RecyclerView rec_descrip;
    ImageView back;
    DataViewModel dataViewModel;
    private ProgressDialog progress;
    Description_Adapter description_adapter;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        back=findViewById(R.id.back);

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        rec_descrip=findViewById(R.id.rec_descrip);
        rec_descrip.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        
        get_des_list();
    }

    private void get_des_list() {

        showprogressbar(true);

        dataViewModel.des_type(this).observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result results) {
                //hideLoader();
                if (results != null) {

                    Subcategorydetails subcategorydetails=results.getSubcategorydetails();
                    List<SubCategoryType> subCategoryTypes=subcategorydetails.getSubCategoryType();

                    showprogressbar(false);

                    if(subCategoryTypes.size() > 0) {
                        description_adapter=new Description_Adapter(getApplicationContext(),subCategoryTypes);
                        rec_descrip.setAdapter(description_adapter);
                    }
                }
            }
        });




    }

    private void showprogressbar(Boolean IS_SHOW) {
        if (IS_SHOW) {
            progress = ProgressDialog.show(Description_Activity.this, "", "");
            progress.setContentView(R.layout.loader);
            progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        } else {
            progress.dismiss();
        }
    }

}
