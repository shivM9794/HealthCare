package com.healthcare.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.healthcare.app.DashBoard.DashBoard_Activity;
import com.healthcare.app.Profile.ProfileActivity;
import com.healthcare.app.R;
import com.healthcare.app.Utility.PreferenceUtils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(PreferenceUtils.isNetworkAvailable(getApplicationContext())) {
                    if (PreferenceUtils.getBoolValue(getApplicationContext(), PreferenceUtils.Login)) {

                        if (PreferenceUtils.getStringValue(getApplicationContext(),PreferenceUtils.Profile_Updated).equalsIgnoreCase("N") || PreferenceUtils.getStringValue(getApplicationContext(),PreferenceUtils.New_User).equalsIgnoreCase("Y")) {
                            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                         //   Toast.makeText(getApplicationContext(), PreferenceUtils.getStringValue(getApplicationContext(),PreferenceUtils.Profile_Updated), Toast.LENGTH_SHORT).show();
                           // Toast.makeText(getApplicationContext(), PreferenceUtils.getStringValue(getApplicationContext(),PreferenceUtils.New_User), Toast.LENGTH_SHORT).show();

                            startActivity(intent);

                        } else {
                            Intent intent = new Intent(getApplicationContext(), DashBoard_Activity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }

                    } else {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }
                    finish();
                }else{

                }




            }
        }, 2000);
        setFCMToken();
    }

    private void setFCMToken() {

        try {

           /* FirebaseMessaging.getInstance().subscribeToTopic("weather")
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (!task.isSuccessful()) {
                                Log.w("Firebase", "Fetching FCM registration token failed", task.getException());
                                //  return;
                            }

                           *//* String token = task.getResult();
                            if (token != null && !token.isEmpty()) {
                                PreferenceUtils.setStringValue(getApplicationContext(), PreferenceUtils.FCMTOKEN, token);
                            }
                            Log.e("Firebase-Token", token);*//*
                        }


                    });*/

            FirebaseMessaging.getInstance().getToken()
                    .addOnCompleteListener(new OnCompleteListener<String>() {
                        @Override
                        public void onComplete(@NonNull Task<String> task) {
                            if (!task.isSuccessful()) {
                                Log.w("Firebase", "Fetching FCM registration token failed", task.getException());
                                return;
                            }

                            String token = task.getResult();
                            if (token != null && !token.isEmpty()) {
                                PreferenceUtils.setStringValue(getApplicationContext(), PreferenceUtils.FCMTOKEN, token);
                            }
                            Log.e("Firebase-Token", token);
                        }


                    });

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
