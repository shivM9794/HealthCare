package com.healthcare.app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.healthcare.app.R;
import com.healthcare.app.Response.BannerDatum;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class Slider_Adapter extends SliderViewAdapter<Slider_Adapter.ViewHolder> {

    Context context;
    List<BannerDatum> bannerData;
    String image_base_url = "https://apkconnectlab.com/healthcareapp/";


    public Slider_Adapter(Context context, List<BannerDatum> bannerData) {
        this.context = context;
        this.bannerData=bannerData;
    }


    @Override
    public Slider_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.slider_img, parent, false);
        return new Slider_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Slider_Adapter.ViewHolder holder, int position) {
        //  List<Image> images=firstPropertyData.getImages();
        Glide.with(context).load(image_base_url+bannerData.get(position).getImage()).into(holder.slider_img);


    }

    @Override
    public int getCount() {
        return bannerData.size();
    }

    public class ViewHolder extends SliderViewAdapter.ViewHolder {

        ImageView slider_img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            slider_img = itemView.findViewById(R.id.slider_img);

        }
    }

}
