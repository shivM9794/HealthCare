package com.healthcare.app.Utility;

import com.healthcare.app.Response.Example;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

public interface FactoryApi {

    @POST("users/putSignupForm")
    @FormUrlEncoded
    Call<Example> signup(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);

    @POST("users/putSignupVerificationForm")
    @FormUrlEncoded
    Call<Example> step_verification(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);

    @POST("health/getHomepageData")
    @FormUrlEncoded
    Call<Example> home_details(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);

    @POST("health/getsubCategoryData")
    @FormUrlEncoded
    Call<Example> sub_cat_type(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);

    @POST("health/getallCategoryData")
    @FormUrlEncoded
    Call<Example> view_all(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);

    @POST("hospital/getHomepageData")
    @FormUrlEncoded
    Call<Example> hosp_list(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);

    @POST("hospital/gethospitaldetailPageData")
    @FormUrlEncoded
    Call<Example> hosp_des(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);

    @POST("doctor/getHomepageData")
    @FormUrlEncoded
    Call<Example> doc_list(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);

    @POST("health/getAllProductList")
    @FormUrlEncoded
    Call<Example> sup_list(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);


    @POST("doctor/getDoctordetailPageData")
    @FormUrlEncoded
    Call<Example> doc_des(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);

    @POST("doctor/bookappointment")
    @FormUrlEncoded
    Call<Example> book_app(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);

    @POST("doctor/submitrating")
    @FormUrlEncoded
    Call<Example> sub_rating(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);

    @POST("hospital/submitrating")
    @FormUrlEncoded
    Call<Example> hos_id(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);

    @POST("shopping/getHomepageData")
    @FormUrlEncoded
    Call<Example> shopp_cart(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);

    @POST("shopping/getproductdetailPageData")
    @FormUrlEncoded
    Call<Example> shopp_cart_des(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);

    @POST("shopping/addtoCart")
    @FormUrlEncoded
    Call<Example> add_cart(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);

    @POST("health/addtoFavouriteSubcategory")
    @FormUrlEncoded
    Call<Example> add_fav(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);

    @POST("health/getsubCategorydetailData")
    @FormUrlEncoded
    Call<Example> des_type(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);

    @POST("shopping/getcartData")
    @FormUrlEncoded
    Call<Example> get_cart(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);

    @POST("shopping/customerorderplace")
    @FormUrlEncoded
    Call<Example> buy_now(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);

    @POST("shopping/customerorderplaceviaCart")
    @FormUrlEncoded
    Call<Example> cart_buy_now(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);

    @POST("shopping/completepaymentwithCOD")
    @FormUrlEncoded
    Call<Example> place_order(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);

    @POST("users/updateProfileData")
    @Multipart
    Call<Example> profile(@HeaderMap Map<String, String> headers, @PartMap Map<String, String> map, @Part List<MultipartBody.Part> image);

    @POST("shopping/getOrderList")
    @FormUrlEncoded
    Call<Example> order_list(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);

    @POST("users/setLogout")
    @FormUrlEncoded
    Call<Example> logout(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);

    @POST("shopping/updateQuantity")
    @FormUrlEncoded
    Call<Example> get_quantity(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);


    @POST("common/getAboutUsData")
    @FormUrlEncoded
    Call<Example> about(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);

    @POST("common/getDisclaimerData")
    @FormUrlEncoded
    Call<Example> disclaimer(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);

    @POST("common/getTermsConditionsData")
    @FormUrlEncoded
    Call<Example> termsConditions(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);

    @POST("common/getPrivacyPolicyData")
    @FormUrlEncoded
    Call<Example> privacypolicy(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);

    @POST("common/getPartnersData")
    @FormUrlEncoded
    Call<Example> partners(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);

    @POST("health/getfavrouteDatalist")
    @FormUrlEncoded
    Call<Example> get_fav(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);


}
