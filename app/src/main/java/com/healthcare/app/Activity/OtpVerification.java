package com.healthcare.app.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.healthcare.app.DashBoard.DashBoard_Activity;
import com.healthcare.app.Profile.ProfileActivity;
import com.healthcare.app.R;
import com.healthcare.app.Response.Result;
import com.healthcare.app.Response.UsersData;
import com.healthcare.app.Utility.PreferenceUtils;
import com.healthcare.app.ViewModel.DataViewModel;

public class OtpVerification extends AppCompatActivity {

    TextView change_no;
    EditText otp_txt;
    String user_id;
    DataViewModel dataViewModel;
    private ProgressDialog progress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        user_id=getIntent().getStringExtra("user_id");

        initviews();

        change_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initviews() {
        change_no=findViewById(R.id.change_no);
        otp_txt=findViewById(R.id.otp_txt);
    }

    public void btn_next(View view) {
        String otp=otp_txt.getText().toString();

        showprogressbar(true);

        dataViewModel.verify_otp(this,user_id,otp).observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result results) {
                //hideLoader();
                if (results != null) {

                    UsersData usersData = results.getUsersData();
                    showprogressbar(false);

                    PreferenceUtils.setStringValue(getApplicationContext(), PreferenceUtils.Userid, String.valueOf(usersData.getUsersId()));
                    PreferenceUtils.setStringValue(getApplicationContext(),PreferenceUtils.mobile, String.valueOf(usersData.getUsersMobile()));

                    if (PreferenceUtils.getStringValue(getApplicationContext(),PreferenceUtils.Profile_Updated).equalsIgnoreCase("N") || PreferenceUtils.getStringValue(getApplicationContext(),PreferenceUtils.New_User).equalsIgnoreCase("Y")) {
                        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("user_id", usersData.getUsersId());
                        startActivity(intent);

                    } else {
                        Intent intent = new Intent(getApplicationContext(), DashBoard_Activity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("user_id", usersData.getUsersId());
                        startActivity(intent);
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
            progress = ProgressDialog.show(OtpVerification.this, "", "");
            progress.setContentView(R.layout.loader);
            progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        } else {
            progress.dismiss();
        }
    }

    public void resend_otp(View view) {

       /* String resend_type="email";
        String email="";

        dataViewModel.get_resend_otp(this,user_id,resend_type,email).observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result results) {
                //hideLoader();
                if (results != null) {

                }

            }
        });*/


    }
}
