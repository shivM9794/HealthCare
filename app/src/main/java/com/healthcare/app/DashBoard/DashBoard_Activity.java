package com.healthcare.app.DashBoard;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.navigation.NavigationView;
import com.healthcare.app.R;
import com.healthcare.app.Utility.DrawerController;
import com.healthcare.app.Utility.PreferenceUtils;
import com.mikhaellopez.circularimageview.CircularImageView;

import me.ibrahimsn.lib.SmoothBottomBar;

public class DashBoard_Activity extends AppCompatActivity /*implements DrawerController*/ {

    private AppBarConfiguration mAppBarConfiguration;
    private NavController navController;
    public static DrawerLayout drawer;
    TextView home;
    CircularImageView user_profile;
    String image_path="https://apkconnectlab.com/healthcareapp/";
    TextView name_txt,txt_mobile_no;
    private NavigationView navigationView;
    /* private BottomNavigationView bottomNavView;*/
    private SmoothBottomBar bottomNavView;
    private CoordinatorLayout contentView;
    Toolbar toolbar;
    String txt="TGP HealthCare";
    ImageView notification;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        initToolbar();
        initNavigation();
        setupSmoothBottomMenu();
        setToolbarr(txt);

    }

    private void initToolbar() {

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }


    private void initNavigation() {

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        bottomNavView = findViewById(R.id.bottom_nav_view);
        contentView = findViewById(R.id.content_view);


        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        View navHeaderView=navigationView.getHeaderView(0);
        home=findViewById(R.id.home_s);
       // home.setText("hhhhh");
        name_txt=navHeaderView.findViewById(R.id.nav_name);
        txt_mobile_no=navHeaderView.findViewById(R.id.nav_no);
        user_profile=navHeaderView.findViewById(R.id.user_profile);

        if( PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.Profile).equals("")){
            Glide.with(getApplicationContext()).load(R.drawable.user).into(user_profile);
        }
        else {
            Glide.with(getApplicationContext()).load(image_path + PreferenceUtils.getStringValue(getApplicationContext(),PreferenceUtils.Profile)).into(user_profile);
            // Glide.with(getActivity()).load(image_base_url+PreferenceUtils.getStringValue(getActivity(),PreferenceUtils.UserImage)).into(profileupdate);
        }

        name_txt.setText(PreferenceUtils.getStringValue(getApplicationContext(),PreferenceUtils.Name));
        txt_mobile_no.setText(PreferenceUtils.getStringValue(getApplicationContext(),PreferenceUtils.mobile));


        if(toolbar!=null) {

            mAppBarConfiguration = new AppBarConfiguration.Builder(/*navController.getGraph()*/
                    R.id.nav_home, R.id.nav_fav, R.id.nav_about,
                    R.id.nav_cart)
                    .setDrawerLayout(drawer)
                    .build();
            //Toolbar toolbar = findViewById(R.id.toolbar);

            NavigationUI.setupWithNavController(toolbar, navController, mAppBarConfiguration);

            NavigationUI.setupWithNavController(navigationView, navController);
            // NavigationUI.setupWithNavController(bottomNavView, navController);
        }
        else{
            drawer.setDrawerListener(null);
        }




       /* bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.plusbtn:
                        Fragment addDetails_fragment=new AddDetails_Fragment();
                        bottomNavView.setVisibility(View.GONE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,addDetails_fragment).commit();

                }
                return false;
            }
        });*/

    }


    private void setupSmoothBottomMenu() {

        PopupMenu popupMenu = new PopupMenu(this, null);
        popupMenu.inflate(R.menu.bottom_nav_menu);
        Menu menu = popupMenu.getMenu();
        bottomNavView.setupWithNavController(menu, navController);
    }



    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            return;
        }
        else {
            super.onBackPressed();
            return;
        }

    }



    public void setToolbarr(String string) {

        home.setText(string);

    }


}

