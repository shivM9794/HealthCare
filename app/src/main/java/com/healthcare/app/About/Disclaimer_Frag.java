package com.healthcare.app.About;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.healthcare.app.Adapter.About_Adapter;
import com.healthcare.app.DashBoard.DashBoard_Activity;
import com.healthcare.app.R;
import com.healthcare.app.Response.AboutBannerData;
import com.healthcare.app.Response.AboutUsData;
import com.healthcare.app.Response.DisclaimerBannerData;
import com.healthcare.app.Response.DisclaimerData;
import com.healthcare.app.Response.Result;
import com.healthcare.app.ViewModel.DataViewModel;

import java.util.ArrayList;

public class Disclaimer_Frag extends Fragment {

    View view;
    TextView rec_disclaimer;
    ImageView image_view;
    DataViewModel dataViewModel;
    String image_path = "https://apkconnectlab.com/healthcareapp/";
    private ProgressDialog progress;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.frag_disclaimer, container, false);

        ((DashBoard_Activity)getActivity()).setToolbarr("Disclaimer");

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);


        rec_disclaimer=view.findViewById(R.id.rec_disclaimer);
        image_view=view.findViewById(R.id.image_view);

        get_disclaimer();

        return view;
    }

    private void get_disclaimer() {

        showprogressbar(true);

        dataViewModel.disclaimer(getActivity()).observe(getActivity(), new Observer<Result>() {
            @Override
            public void onChanged(Result results) {
                //hideLoader();
                if (results != null) {

                    showprogressbar(false);


                    DisclaimerBannerData disclaimerBannerData = results.getDisclaimerBannerData();
                    DisclaimerData disclaimerData = results.getDisclaimerData();

                    Glide.with(getActivity()).load(image_path + disclaimerBannerData.getImage()).into(image_view);
                    rec_disclaimer.setText(disclaimerData.getDescription());

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
