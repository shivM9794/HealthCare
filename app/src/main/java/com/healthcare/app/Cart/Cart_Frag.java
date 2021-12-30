package com.healthcare.app.Cart;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.healthcare.app.Adapter.DoctorsList_Adapter;
import com.healthcare.app.Adapter.HealthCart_Adapter;
import com.healthcare.app.Adapter.HealthSupp_Adapter;
import com.healthcare.app.Adapter.Shop_Cart_Adapter;
import com.healthcare.app.Adapter.Shopping_Adapter;
import com.healthcare.app.DashBoard.DashBoard_Activity;
import com.healthcare.app.Doctors.DoctorsList_Activity;
import com.healthcare.app.R;
import com.healthcare.app.Response.Doctordatum;
import com.healthcare.app.Response.Result;
import com.healthcare.app.Response.ShopcartDatum;
import com.healthcare.app.ViewModel.DataViewModel;

import java.util.ArrayList;
import java.util.List;

public class Cart_Frag extends Fragment {

    View view;
    private ProgressDialog progress;
    DataViewModel dataViewModel;
    RecyclerView rec_medicine;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.frag_cart, container, false);

        ((DashBoard_Activity)getActivity()).setToolbarr("Shopping");

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        rec_medicine=view.findViewById(R.id.rec_medicine);
        rec_medicine.setLayoutManager(new LinearLayoutManager(getActivity()));

        get_medicinelist();

        return view;
    }

    private void get_medicinelist() {

        showprogressbar(true);

        dataViewModel.shopp_cart(getActivity()).observe(getActivity(), new Observer<Result>() {
            @Override
            public void onChanged(Result results) {
                //hideLoader();
                if (results != null) {

                    List<ShopcartDatum> shopcartData = results.getShopcartData();

                    showprogressbar(false);

                    if(shopcartData.size()>0) {
                       Shopping_Adapter shopping_adapter=new Shopping_Adapter(getActivity(),shopcartData);
                        rec_medicine.setAdapter(shopping_adapter);
                    }
                }
            }
        });


    }

    private void showprogressbar(Boolean IS_SHOW) {
        if (IS_SHOW) {
            progress = ProgressDialog.show(getActivity(), "", "");
            progress.setContentView(R.layout.loader);
            progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        } else {
            progress.dismiss();
        }
    }

}
