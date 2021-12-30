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

import com.bumptech.glide.Glide;
import com.healthcare.app.DashBoard.DashBoard_Activity;
import com.healthcare.app.R;
import com.healthcare.app.Response.AboutBannerData;
import com.healthcare.app.Response.AboutUsData;
import com.healthcare.app.Response.Result;
import com.healthcare.app.Response.TermsBannerData;
import com.healthcare.app.Response.TermsConditionsData;
import com.healthcare.app.ViewModel.DataViewModel;

public class TermsCondition extends Fragment {

    View view;
    TextView rec_termscond;
    String image_path = "https://apkconnectlab.com/healthcareapp/";
    DataViewModel dataViewModel;
    private ProgressDialog progress;
    ImageView image_view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.frag_termscond, container, false);

        ((DashBoard_Activity)getActivity()).setToolbarr("Terms & Conditions");

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        rec_termscond=view.findViewById(R.id.rec_termscond);
        image_view=view.findViewById(R.id.image_view);

        get_termscond();



        return view;
    }

    private void get_termscond() {

        showprogressbar(true);

        dataViewModel.termsConditions(getActivity()).observe(getActivity(), new Observer<Result>() {
            @Override
            public void onChanged(Result results) {
                //hideLoader();
                if (results != null) {

                    showprogressbar(false);
                    TermsConditionsData termsConditionsData = results.getTermsConditionsData();
                    TermsBannerData termsBannerData = results.getTermsBannerData();

                    Glide.with(getActivity()).load(image_path + termsBannerData.getImage()).into(image_view);
                    rec_termscond.setText(termsConditionsData.getDescription());

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
