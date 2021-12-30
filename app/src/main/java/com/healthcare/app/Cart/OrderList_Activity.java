package com.healthcare.app.Cart;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.healthcare.app.Adapter.OrderListAdapter;
import com.healthcare.app.R;
import com.healthcare.app.Response.Myorder;
import com.healthcare.app.Response.OrderplaceData;
import com.healthcare.app.Response.Result;
import com.healthcare.app.ViewModel.DataViewModel;

import java.util.List;

public class OrderList_Activity extends AppCompatActivity {

    RecyclerView rec_order;
    private ProgressDialog progress;
    ImageView back;
    String image_path="https://apkconnectlab.com/healthcareapp/";
    DataViewModel dataViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        rec_order=findViewById(R.id.rec_order);
        rec_order.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        back=findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        get_order();

    }

    private void get_order() {

        showprogressbar(true);

        dataViewModel.order_list(this).observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result results) {
                //hideLoader();
                if (results != null) {

                    showprogressbar(false);

                    List<Myorder> orderplaceDataList=results.getMyorderList();

                    if(orderplaceDataList.size()>0) {
                        OrderListAdapter orderListAdapter = new OrderListAdapter(getApplicationContext(), orderplaceDataList);
                        rec_order.setAdapter(orderListAdapter);
                    }
                    else{
                        //alert_dialog();
                        Toast.makeText(getApplicationContext(), "No Data Found", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }

    private void alert_dialog() {

        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(OrderList_Activity.this);
        builder.setTitle("Permission Denied");
        builder.setMessage("No Data Found");
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });
        builder.setCancelable(false);
        builder.show();


    }

    private void showprogressbar(Boolean IS_SHOW) {
                    if (IS_SHOW) {
                        progress = ProgressDialog.show(OrderList_Activity.this, "", "");
                        progress.setContentView(R.layout.loader);
                        progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                    } else {
                        progress.dismiss();
                    }
                }
}
