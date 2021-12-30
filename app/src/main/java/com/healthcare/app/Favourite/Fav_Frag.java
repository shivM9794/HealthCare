package com.healthcare.app.Favourite;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.healthcare.app.Adapter.FavList_Adapter;
import com.healthcare.app.Adapter.Fav_Adapter;
import com.healthcare.app.DashBoard.DashBoard_Activity;
import com.healthcare.app.R;
import com.healthcare.app.Response.FavouriteSubCat;
import com.healthcare.app.Response.PartnerBannerData;
import com.healthcare.app.Response.PartnersData;
import com.healthcare.app.Response.Result;
import com.healthcare.app.ViewModel.DataViewModel;

import java.util.ArrayList;
import java.util.List;

public class Fav_Frag extends Fragment {

    View view;
    RecyclerView rec_fav;
    DataViewModel dataViewModel;
    private ProgressDialog progress;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.frag_fav, container, false);

        ((DashBoard_Activity)getActivity()).setToolbarr("Favorite");

        rec_fav=view.findViewById(R.id.rec_fav);
        rec_fav.setLayoutManager(new GridLayoutManager(getActivity(),2));

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);


        get_favlist();

        return view;
    }

    private void get_favlist() {

        showprogressbar(true);

        dataViewModel.get_fav(getActivity()).observe(getActivity(), new Observer<Result>() {
            @Override
            public void onChanged(Result results) {
                //hideLoader();
                if (results != null) {

                    showprogressbar(false);
                    List<FavouriteSubCat> favouriteSubCatList = results.getFavouriteSubCatList();

                    if(favouriteSubCatList.size()>0) {

                        FavList_Adapter fav_adapter = new FavList_Adapter(getActivity(), favouriteSubCatList);
                        rec_fav.setAdapter(fav_adapter);

                    }
                    else{
                        Toast.makeText(getActivity(), "No Data Found", Toast.LENGTH_SHORT).show();
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
