package com.healthcare.app.Notifiction;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.healthcare.app.Adapter.Notification_Adapter;
import com.healthcare.app.R;
import com.healthcare.app.ViewModel.DataViewModel;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MultipartBody;

public class Notification_activity extends AppCompatActivity {

    RecyclerView rec_notification;
    Notification_Adapter notification_adapter;
    MaterialToolbar tool_bar;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.notification_act);


            initviews();


        tool_bar=findViewById(R.id.tool_bar);
        tool_bar.setNavigationIcon(R.drawable.ic_baseline_keyboard_backspace_24);

        tool_bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();

            }
        });


        get_notificationlist();


    }

    private void get_notificationlist() {
        ArrayList<String> notification_list=new ArrayList<>();
        notification_list.add("Your appointment is booked.");
        notification_list.add("Doctor is not available");

        notification_adapter=new Notification_Adapter(getApplicationContext(),notification_list);
        rec_notification.setAdapter(notification_adapter);
    }

    private void initviews() {
        rec_notification=findViewById(R.id.rec_notification);
        rec_notification.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }



}

