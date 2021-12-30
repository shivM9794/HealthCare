package com.healthcare.app.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.healthcare.app.R;
import com.healthcare.app.Repository.DataRepository;
import com.healthcare.app.Response.Result;
import com.healthcare.app.Utility.PreferenceUtils;
import com.healthcare.app.ViewModel.DataViewModel;

public class Logout_Activity extends AppCompatActivity {

    DataViewModel dataViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        show_alert();

    }

    private void show_alert() {

        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(Logout_Activity.this);
        builder.setTitle("TGP HealthCare");
        builder.setMessage("Are you sure you want to exit ?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                logout();

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
        
    }

    private void logout() {

        dataViewModel.logout(this).observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result results) {
                //hideLoader();
                if (results != null) {

                    PreferenceUtils.setBoolValue(getApplicationContext(), PreferenceUtils.Login, false);

                    Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                    intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent1);

                }

            }
        });

    }


}


