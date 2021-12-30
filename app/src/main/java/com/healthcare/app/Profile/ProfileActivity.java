package com.healthcare.app.Profile;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.healthcare.app.Cart.OrderList_Activity;
import com.healthcare.app.DashBoard.DashBoard_Activity;
import com.healthcare.app.R;
import com.healthcare.app.Response.Result;
import com.github.drjacky.imagepicker.ImagePicker;
import com.healthcare.app.Response.UsersData;
import com.healthcare.app.Utility.FilePath;
import com.healthcare.app.Utility.PreferenceUtils;
import com.healthcare.app.ViewModel.DataViewModel;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.internal.cache.DiskLruCache;

public class ProfileActivity extends AppCompatActivity {

    ImageView back,order;
    private ProgressDialog progress;
    String user_name="",emaill="";
    String phone_no="",address="";
    String profile="";
    List<MultipartBody.Part> files;
    String image_path="https://apkconnectlab.com/healthcareapp/";
    CircularImageView profileupdate;
    EditText user,mobile,email,edit_address;
    DataViewModel dataViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        initviews();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        if( PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.Profile).equals("")){
            Glide.with(getApplicationContext()).load(R.drawable.user).into(profileupdate);
        }
        else {
            Glide.with(getApplicationContext()).load(image_path + PreferenceUtils.getStringValue(getApplicationContext(),PreferenceUtils.Profile)).into(profileupdate);
            // Glide.with(getActivity()).load(image_base_url+PreferenceUtils.getStringValue(getActivity(),PreferenceUtils.UserImage)).into(profileupdate);
        }

        profileupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.Companion.with(ProfileActivity.this)
                        .crop()	    			//Crop image(Optional), Check Customization for more option
                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .start(0);
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getApplicationContext(), OrderList_Activity.class);
                startActivity(intent);

            }

        });

        if(PreferenceUtils.getStringValue(getApplicationContext(),PreferenceUtils.Name).equals("0")){
            user.setHint("Enter Name");
        }
        else{
            user.setText(PreferenceUtils.getStringValue(getApplicationContext(),PreferenceUtils.Name));

        }

        if(PreferenceUtils.getStringValue(getApplicationContext(),PreferenceUtils.mobile).equals("0")){
            mobile.setHint("Enter mobile");
        }
        else{
            mobile.setText(PreferenceUtils.getStringValue(getApplicationContext(),PreferenceUtils.mobile));

        }

        if(PreferenceUtils.getStringValue(getApplicationContext(),PreferenceUtils.email).equals("0")){
            email.setHint("Enter Email");
        }
        else{
            email.setText(PreferenceUtils.getStringValue(getApplicationContext(),PreferenceUtils.email));

        }

        if(PreferenceUtils.getStringValue(getApplicationContext(),PreferenceUtils.address).equals("0")){
            edit_address.setHint("Enter Address");
        }
        else{
            edit_address.setText(PreferenceUtils.getStringValue(getApplicationContext(),PreferenceUtils.address));

        }


    }

    private void initviews() {

        user=findViewById(R.id.user);
        mobile=findViewById(R.id.mobile);
        email=findViewById(R.id.email);
        edit_address=findViewById(R.id.edit_address);
        back=findViewById(R.id.back);
        order=findViewById(R.id.order);
        profileupdate=findViewById(R.id.profileupdate);

    }


    private void get_profile() {

        showprogressbar(true);

        dataViewModel.profile(this,user_name,phone_no,emaill,address,files).observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result results) {
                //hideLoader();
                if (results != null) {

                    showprogressbar(false);

                    UsersData usersData=results.getUsersData();

                    PreferenceUtils.setStringValue(getApplicationContext(),PreferenceUtils.Name,usersData.getUsersName());
                    PreferenceUtils.setStringValue(getApplicationContext(),PreferenceUtils.email,usersData.getUsersEmail());
                    PreferenceUtils.setStringValue(getApplicationContext(),PreferenceUtils.mobile, String.valueOf(usersData.getUsersMobile()));
                    PreferenceUtils.setStringValue(getApplicationContext(),PreferenceUtils.address,usersData.getUsersAddress());
                    PreferenceUtils.setStringValue(getApplicationContext(),PreferenceUtils.Profile_Updated,usersData.getProfileUpdated());
                    PreferenceUtils.setStringValue(getApplicationContext(),PreferenceUtils.New_User,usersData.getNewUser());
                    PreferenceUtils.setStringValue(getApplicationContext(),PreferenceUtils.Profile,usersData.getUsersImage());
                    Glide.with(getApplicationContext()).load(image_path+usersData.getUsersImage()).into(profileupdate);
                    //Toast.makeText(getApplicationContext(), PreferenceUtils.getStringValue(getApplicationContext(),PreferenceUtils.Profile_Updated), Toast.LENGTH_SHORT).show();
                   // Toast.makeText(getApplicationContext(), PreferenceUtils.getStringValue(getApplicationContext(),PreferenceUtils.New_User), Toast.LENGTH_SHORT).show();

                    Intent intent=new Intent(getApplicationContext(), DashBoard_Activity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                }

            }
        });
    }

    private void showprogressbar(Boolean IS_SHOW) {
        if (IS_SHOW) {
            progress = ProgressDialog.show(ProfileActivity.this, "", "");
            progress.setContentView(R.layout.loader);
            progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        } else {
            progress.dismiss();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {

            files = new ArrayList<>();

            final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/*; charset=utf-8");

            Uri selectedImage = data.getData();
           // profileupdate.setImageURI(selectedImage);

             profile = FilePath.getPath(getApplicationContext(), selectedImage);

            // Toast.makeText(getActivity(), profile, Toast.LENGTH_SHORT).show();

            if (profile != null && !profile.isEmpty()) {
                File panFile = new File(profile);
                files.add(MultipartBody.Part.createFormData("users_image",
                        panFile.getName(),
                        RequestBody.create(panFile, MEDIA_TYPE_PNG)));

            }
            else{
                Toast.makeText(getApplicationContext(),"image not found",Toast.LENGTH_SHORT).show();
            }

        }
        else{
            Toast.makeText(getApplicationContext(),"image not found",Toast.LENGTH_SHORT).show();
        }

        }




    public void btn_update(View view) {

        boolean bool = true;

        user_name = user.getText().toString().trim();

        if(user_name.equals("")){
            bool=false;
            user.setError("Please enter username");
        }else if(user_name.length()<3){
            bool=false;
            user.setError("Please enter at least 3 characters");
        }else{
            user.setError(null);
        }

        emaill= email.getText().toString().trim();
        if(emaill.equals("")){
            bool=false;
            email.setError("Please enter your email id");

        }else if(validateEmail()){
            bool=false;
            email.setError("Email id is not valid!!");

        }else{
            email.setError(null);
        }


        phone_no=mobile.getText().toString();
        if(phone_no.equals("")){
            bool=false;
            mobile.setError("Please enter your mobile no");

        }else if(validateMobileNo()){
            bool=false;
            mobile.setError("Mobile no is not valid!!");

        }else{
            mobile.setError(null);
        }

        address=edit_address.getText().toString();



        if(!bool) return;


        get_profile();;

    }

    private boolean validateMobileNo() {
        String mobileRegex = "(0/91)?[6-9][0-9]{9}";

        Pattern pat = Pattern.compile(mobileRegex);
        if (phone_no == null)
            return true;
        return !pat.matcher(phone_no).matches();
    }

    private boolean validateEmail() {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (emaill == null)
            return true;
        return !pat.matcher(emaill).matches();
    }

}
