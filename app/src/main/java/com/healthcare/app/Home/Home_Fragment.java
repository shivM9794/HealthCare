package com.healthcare.app.Home;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.healthcare.app.Activity.MainActivity;
import com.healthcare.app.Activity.OtpVerification;
import com.healthcare.app.Adapter.Experienced_Adapter;
import com.healthcare.app.Adapter.HealthSol_Adapter;
import com.healthcare.app.Adapter.HealthSupp_Adapter;
import com.healthcare.app.Adapter.Slider_Adapter;
import com.healthcare.app.Adapter.TopRated_Adapter;
import com.healthcare.app.Cart.SuppList_Activity;
import com.healthcare.app.DashBoard.DashBoard_Activity;
import com.healthcare.app.Doctors.DoctorsList_Activity;
import com.healthcare.app.HealthSolutions.Health_Sol_Activity;
import com.healthcare.app.Hospitals.HospitalList_Activity;
import com.healthcare.app.R;
import com.healthcare.app.Response.BannerDatum;
import com.healthcare.app.Response.Categorydatum;
import com.healthcare.app.Response.Doctordatum;
import com.healthcare.app.Response.HospitalDatum;
import com.healthcare.app.Response.ProdDatum;
import com.healthcare.app.Response.Result;
import com.healthcare.app.Response.UsersData;
import com.healthcare.app.ViewModel.DataViewModel;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class Home_Fragment extends Fragment {

    View view;
    RecyclerView rec_list,rec_exp_docs,rec_health_supp,rec_top_rated_hos;
    HealthSol_Adapter healthSol_adapter;
    HealthSupp_Adapter healthSupp_adapter;
    Experienced_Adapter experienced_adapter;
    TopRated_Adapter topRated_adapter;
    Button btn_view;
    SliderView image_view;
    List<Doctordatum> doctordata;
    List<ProdDatum> prodData;
    TextView title,txt_expdoc,txt_health,txt_rated_hosp,expdoc_all,txt_rated_hosp_all,supp_all;
    List<HospitalDatum> hospitalData;
    private ProgressDialog progress;
    DataViewModel dataViewModel;
    Slider_Adapter sliderAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.frag_home, container, false);

        initviews();

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);


        get_list();

        expdoc_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getActivity(), DoctorsList_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });

        supp_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), SuppList_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        txt_rated_hosp_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getActivity(), HospitalList_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });

        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), Health_Sol_Activity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private void get_expdocs_list() {

        experienced_adapter=new Experienced_Adapter(getActivity(),doctordata);
        rec_exp_docs.setAdapter(experienced_adapter);

    }

    private void get_list() {

        showprogressbar(true);

        dataViewModel.home_details(getActivity()).observe(getActivity(), new Observer<Result>() {
            @Override
            public void onChanged(Result results) {
                //hideLoader();
                if (results != null) {

                    List<Categorydatum> categorydatum = results.getCategorydata();
                    List<BannerDatum> bannerData=results.getBannerData();

                    doctordata=results.getDoctordata();
                    prodData=results.getProdData();
                    hospitalData=results.getHospitalData();

                    showprogressbar(false);

                    if(bannerData.size()>0){

                        sliderAdapter = new Slider_Adapter(getActivity(), bannerData);
                        image_view.setSliderAdapter(sliderAdapter);
                        image_view.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
                        image_view.setScrollTimeInSec(3);
                        image_view.setAutoCycle(true);
                        image_view.startAutoCycle();

                    }

                    if(categorydatum.size()>0) {
                        title.setVisibility(View.VISIBLE);
                        btn_view.setVisibility(View.VISIBLE);
                        healthSol_adapter = new HealthSol_Adapter(getActivity(), categorydatum);
                        rec_list.setAdapter(healthSol_adapter);
                    }

                    if(doctordata.size()>0) {
                        txt_expdoc.setVisibility(View.VISIBLE);
                        get_expdocs_list();
                    }
                    if(prodData.size()>0){
                        txt_health.setVisibility(View.VISIBLE);
                        get_health_supp_list();
                    }
                    if(hospitalData.size()>0) {
                        txt_rated_hosp.setVisibility(View.VISIBLE);
                        get_top_rated_hos_list();
                    }


                } else {
                    showprogressbar(false);
                }
            }
        });
    }




    private void get_health_supp_list() {


        healthSupp_adapter=new HealthSupp_Adapter(getActivity(),prodData);
        rec_health_supp.setAdapter(healthSupp_adapter);

    }

    private void get_top_rated_hos_list() {

        topRated_adapter=new TopRated_Adapter(getActivity(),hospitalData);
        rec_top_rated_hos.setAdapter(topRated_adapter);

    }

    private void initviews() {

        rec_list=view.findViewById(R.id.rec_list);
        rec_list.setLayoutManager(new GridLayoutManager(getActivity(),2));

        expdoc_all=view.findViewById(R.id.expdoc_all);
        supp_all=view.findViewById(R.id.supp_all);
        txt_rated_hosp_all=view.findViewById(R.id.txt_rated_hosp_all);

        rec_exp_docs=view.findViewById(R.id.rec_exp_docs);
        rec_exp_docs.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

        rec_health_supp=view.findViewById(R.id.rec_health_supp);
        rec_health_supp.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

        rec_top_rated_hos=view.findViewById(R.id.rec_top_rated_hos);
        rec_top_rated_hos.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

        btn_view=view.findViewById(R.id.btn_view);

        image_view=view.findViewById(R.id.image_view);

        title=view.findViewById(R.id.title);
        txt_expdoc=view.findViewById(R.id.txt_expdoc);
        txt_health=view.findViewById(R.id.txt_health);
        txt_rated_hosp=view.findViewById(R.id.txt_rated_hosp);

        title.setVisibility(View.GONE);
        txt_expdoc.setVisibility(View.GONE);
        txt_health.setVisibility(View.GONE);
        txt_rated_hosp.setVisibility(View.GONE);
        btn_view.setVisibility(View.GONE);

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



    @Override
    public void onResume() {
        super.onResume();
        ((DashBoard_Activity)getActivity()).setToolbarr("TGP HealthCare");
    }
}
