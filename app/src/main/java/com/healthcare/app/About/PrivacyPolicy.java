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
import com.healthcare.app.Response.PartnerBannerData;
import com.healthcare.app.Response.PartnersData;
import com.healthcare.app.Response.PrivacyBannerData;
import com.healthcare.app.Response.PrivacyPolicyData;
import com.healthcare.app.Response.Result;
import com.healthcare.app.ViewModel.DataViewModel;

public class PrivacyPolicy extends Fragment {

    View view;
    TextView rec_priv_policy;
    ImageView image_view;
    String image_path = "https://apkconnectlab.com/healthcareapp/";
    DataViewModel dataViewModel;
    private ProgressDialog progress;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.frag_privacy_policy, container, false);

        ((DashBoard_Activity)getActivity()).setToolbarr("Privacy Policy");


        rec_priv_policy=view.findViewById(R.id.rec_priv_policy);
        image_view=view.findViewById(R.id.image_view);

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        get_privacypolicy();


        return view;
    }

    private void get_privacypolicy() {
        showprogressbar(true);

        dataViewModel.privacypolicy(getActivity()).observe(getActivity(), new Observer<Result>() {
            @Override
            public void onChanged(Result results) {
                //hideLoader();
                if (results != null) {

                    showprogressbar(false);
                    PrivacyPolicyData privacyPolicyData = results.getPrivacyPolicyData();
                    PrivacyBannerData privacyBannerData = results.getPrivacyBannerData();

                    Glide.with(getActivity()).load(image_path + privacyBannerData.getImage()).into(image_view);
                    rec_priv_policy.setText(privacyPolicyData.getDescription());

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
