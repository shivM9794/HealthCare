package com.healthcare.app.HealthSolutions;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.healthcare.app.Adapter.Fav_Adapter;
import com.healthcare.app.Adapter.HealthSol_Adapter;
import com.healthcare.app.R;
import com.healthcare.app.Response.Categorydatum;
import com.healthcare.app.Response.Result;
import com.healthcare.app.Response.Subcategorydatum;
import com.healthcare.app.ViewModel.DataViewModel;

import java.util.ArrayList;
import java.util.List;

public class Health_Sol_Type extends AppCompatActivity {

    RecyclerView rec_heal_type;
    ImageView back;
    String cat_name;
    TextView txt_title;
    DataViewModel dataViewModel;
    private ProgressDialog progress;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.type_health_sol);

        back=findViewById(R.id.back);

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        cat_name=getIntent().getStringExtra("cat_name");

        txt_title=findViewById(R.id.txt_title);
        txt_title.setText(cat_name);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        rec_heal_type=findViewById(R.id.rec_heal_type);
        rec_heal_type.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        
        get_heal_type_list();
    }

    private void get_heal_type_list() {

        showprogressbar(true);

        dataViewModel.sub_cat_type(this).observe(this, new Observer<Result>() {
                    @Override
                    public void onChanged(Result results) {
                        //hideLoader();
                        if (results != null) {

                            List<Subcategorydatum> subcategorydata = results.getSubcategorydata();

                            showprogressbar(false);

                            if(subcategorydata.size() > 0) {
                                Fav_Adapter fav_adapter=new Fav_Adapter(getApplicationContext(),subcategorydata);
                                rec_heal_type.setAdapter(fav_adapter);
                            }
                        }
                    }
                });


    }

    private void showprogressbar(Boolean IS_SHOW) {
        if (IS_SHOW) {
            progress = ProgressDialog.show(Health_Sol_Type.this, "", "");
            progress.setContentView(R.layout.loader);
            progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        } else {
            progress.dismiss();
        }
    }

}
