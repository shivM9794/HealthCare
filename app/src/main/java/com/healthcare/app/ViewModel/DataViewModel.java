package com.healthcare.app.ViewModel;

import android.app.Application;
import android.content.Context;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.healthcare.app.Repository.DataRepository;
import com.healthcare.app.Response.Result;

import java.util.List;

import okhttp3.MultipartBody;

public class DataViewModel extends AndroidViewModel {

    private DataRepository dataRepository;

    public DataViewModel(@NonNull Application application) {
        super(application);
        dataRepository = new DataRepository(application);
    }

    public LiveData<Result> signup(Context context, String num) {
        return dataRepository.signup(context,num);
    }

    public LiveData<Result> verify_otp(Context context,String num,String otp) {
        return dataRepository.verify_otp(context,num,otp);
    }

    public LiveData<Result> home_details(Context context) {
        return dataRepository.home_details(context);
    }

    public LiveData<Result> sub_cat_type(Context context) {
        return dataRepository.sub_cat_type(context);
    }

    public LiveData<Result> view_all(Context context) {
        return dataRepository.view_all(context);
    }

    public LiveData<Result> hosp_list(Context context) {
        return dataRepository.hosp_list(context);
    }

    public LiveData<Result> doc_list(Context context) {
        return dataRepository.doc_list(context);
    }

    public LiveData<Result> sup_list(Context context) {
        return dataRepository.sup_list(context);
    }

    public LiveData<Result> hos_des(Context context,String hosp_id) {
        return dataRepository.hos_des(context,hosp_id);
    }

    public LiveData<Result> doc_des(Context context,String doc_id) {
        return dataRepository.doc_des(context,doc_id);
    }

    public LiveData<Result> book_app(Context context,String doc_id,String fee,String date, String time) {
        return dataRepository.book_app(context,doc_id,fee,date,time);
    }

    public LiveData<Result> sub_rating(Context context,String doc_id,Float rating) {
        return dataRepository.sub_rating(context, doc_id, rating);
    }

    public LiveData<Result> hos_sub_rating(Context context,String hos_id,Float rating) {
        return dataRepository.hos_sub_rating(context, hos_id, rating);
    }

    public LiveData<Result> shopp_cart(Context context) {
        return dataRepository.shopp_cart(context);
    }

    public LiveData<Result> shopp_cart_des(Context context,String subcat_id) {
        return dataRepository.shopp_cart_des(context,subcat_id);
    }

    public LiveData<Result> add_cart(Context context,String prod_id) {
        return dataRepository.add_cart(context,prod_id);
    }

    public LiveData<Result> add_fav(Context context) {
        return dataRepository.add_fav(context);
    }

    public LiveData<Result> des_type(Context context) {

        return dataRepository.des_type(context);
    }

    public LiveData<Result> get_cart(Context context) {

        return dataRepository.get_cart(context);
    }

    public LiveData<Result> buy_now(Context context,String prod_id) {

        return dataRepository.buy_now(context,prod_id);
    }

    public LiveData<Result> cart_buy_now(Context context) {

        return dataRepository.cart_buy_now(context);
    }

    public LiveData<Result> place_order(Context context,String payment_mode) {

        return dataRepository.place_order(context,payment_mode);
    }

    public LiveData<Result> profile(Context context, String user_name, String phone_no, String email, String address, List<MultipartBody.Part> files) {

        return dataRepository.profile(context,user_name,phone_no,email,address,files);
    }

    public LiveData<Result> order_list(Context context) {

        return dataRepository.order_list(context);
    }

    public LiveData<Result> logout(Context context) {

        return dataRepository.logout(context);
    }

    public LiveData<Result> about(Context context) {

        return dataRepository.about(context);
    }

    public LiveData<Result> disclaimer(Context context) {

        return dataRepository.disclaimer(context);
    }

    public LiveData<Result> termsConditions(Context context) {

        return dataRepository.termsConditions(context);
    }

    public LiveData<Result> privacypolicy(Context context) {

        return dataRepository.privacypolicy(context);
    }

    public LiveData<Result> partners(Context context) {

        return dataRepository.partners(context);
    }

    public LiveData<Result> get_fav(Context context) {

        return dataRepository.get_fav(context);
    }


}
