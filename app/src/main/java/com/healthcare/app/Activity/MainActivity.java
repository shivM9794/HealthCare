package com.healthcare.app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.healthcare.app.R;
import com.healthcare.app.Response.Result;
import com.healthcare.app.Response.UsersData;
import com.healthcare.app.Utility.PreferenceUtils;
import com.healthcare.app.ViewModel.DataViewModel;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    DataViewModel dataViewModel;
    EditText mobile;
    CheckBox chk_policy;
    String phone_no = "";
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        initviews();
    }

    private void initviews() {

        mobile = findViewById(R.id.num);

        mobile.setHint("Mobile Number");

        chk_policy = findViewById(R.id.chk_policy);


    }

    public void btn_next(View view) {

        boolean bool = true;


        phone_no = mobile.getText().toString();
        if (phone_no.equals("")) {
            bool = false;
            mobile.setError("Please enter your mobile no");

        } else if (validateMobileNo()) {
            bool = false;
            mobile.setError("Mobile no is not valid!!");

        } else {
            mobile.setError(null);
        }


        if (!chk_policy.isChecked()) {
            bool = false;
            Toast.makeText(getApplicationContext(), "You must agree to our Terms & Conditions for signing up with us.", Toast.LENGTH_LONG).show();
        }

        if (!bool) return;

        get_signup();



    }

    private boolean validateMobileNo() {
        String mobileRegex = "(0/91)?[6-9][0-9]{9}";

        Pattern pat = Pattern.compile(mobileRegex);
        if (phone_no == null)
            return true;
        return !pat.matcher(phone_no).matches();
    }

    private void get_signup() {

        showprogressbar(true);

        dataViewModel.signup(this, phone_no).observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result results) {
                //hideLoader();
                if (results != null) {

                    UsersData usersData = results.getUsersData();
                    showprogressbar(false);

                    setLogin(true);
                    setLoggedIn();

                    Intent intent = new Intent(getApplicationContext(), OtpVerification.class);
                    intent.putExtra("user_id",String.valueOf(usersData.getUsersId()));
                    PreferenceUtils.setStringValue(getApplicationContext(),PreferenceUtils.Profile_Updated,usersData.getProfileUpdated());
                    PreferenceUtils.setStringValue(getApplicationContext(),PreferenceUtils.New_User,usersData.getNewUser());
                    startActivity(intent);


                } else {
                    showprogressbar(false);
                }
            }
        });
    }

    private void showprogressbar(Boolean IS_SHOW) {
        if (IS_SHOW) {
            progress = ProgressDialog.show(MainActivity.this, "", "");
            progress.setContentView(R.layout.loader);
            progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        } else {
            progress.dismiss();
        }
    }

    private void setLoggedIn() {
        PreferenceUtils.setBoolValue(this, PreferenceUtils.Login, true);
    }

    private void setLogin(boolean bool) {
        PreferenceUtils.setBoolValue(this, PreferenceUtils.LoginType, bool);
    }

}
