package com.healthcare.app.HealthSolutions;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.healthcare.app.Adapter.Tab_Adapter;
import com.healthcare.app.R;
import com.healthcare.app.Response.FavouriteData;
import com.healthcare.app.Response.Result;
import com.healthcare.app.Utility.PreferenceUtils;
import com.healthcare.app.ViewModel.DataViewModel;

public class Description_Tablayout extends AppCompatActivity {

    ViewPager view_pager;
    TabLayout tablayout;
    ImageView back,fav;
    DataViewModel dataViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        back=findViewById(R.id.back);
        fav=findViewById(R.id.fav);

        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                add_fav();

            }
        });

        if(PreferenceUtils.getStringValue(getApplicationContext(),PreferenceUtils.Fav).equalsIgnoreCase("Y"))
                fav.setBackgroundResource(R.drawable.ic_baseline_favorite_24);

            else{
                fav.setBackgroundResource(R.drawable.ic_baseline_favorite_border_24);

            }


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        tablayout=findViewById(R.id.tablayout);
        view_pager=findViewById(R.id.view_pager);

        tablayout.addTab(tablayout.newTab().setText("Overview"));
        tablayout.addTab(tablayout.newTab().setText("Description"));
        tablayout.addTab(tablayout.newTab().setText("Causes"));
        tablayout.addTab(tablayout.newTab().setText("Symptoms"));
        tablayout.addTab(tablayout.newTab().setText("Warning Signs"));
        tablayout.addTab(tablayout.newTab().setText("Self Care"));
        tablayout.addTab(tablayout.newTab().setText("Actions"));
        tablayout.addTab(tablayout.newTab().setText("Test"));
        tablayout.addTab(tablayout.newTab().setText("Further Info"));
        tablayout.addTab(tablayout.newTab().setText("Source"));
        tablayout.addTab(tablayout.newTab().setText("About"));

        tablayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final Tab_Adapter adapter = new Tab_Adapter(this,getSupportFragmentManager(), tablayout.getTabCount());
        view_pager.setAdapter(adapter);

        view_pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                view_pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void add_fav() {

        dataViewModel.add_fav(this).observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result results) {
                //hideLoader();
                if (results != null) {

                    FavouriteData favouriteData=results.getFavouriteData();

                    if(favouriteData.getFavouriteSubCat().equalsIgnoreCase("Y")) {

                        fav.setBackgroundResource(R.drawable.ic_baseline_favorite_24);
                        PreferenceUtils.setStringValue(getApplicationContext(),PreferenceUtils.Fav,favouriteData.getFavouriteSubCat());
                    }

                    else{

                        fav.setBackgroundResource(R.drawable.ic_baseline_favorite_border_24);
                        PreferenceUtils.setStringValue(getApplicationContext(),PreferenceUtils.Fav,favouriteData.getFavouriteSubCat());

                    }

                }
            }
        });

    }
}

