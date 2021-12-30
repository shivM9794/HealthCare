package com.healthcare.app.Repository;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.healthcare.app.Response.Example;
import com.healthcare.app.Response.Result;
import com.healthcare.app.Utility.ApiService;
import com.healthcare.app.Utility.KeyGenerationClass;
import com.healthcare.app.Utility.PreferenceUtils;

import java.util.HashMap;
import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataRepository {

    Context context;

    public DataRepository(Context applicationContext) {
        this.context = applicationContext;
    }

        private MutableLiveData<Result> signup = new MutableLiveData<>();

        public MutableLiveData<Result> signup (Context context, String num){
        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);

        HashMap<String, String> params = new HashMap<>();

        params.put("users_mobile", num);
       // params.put("term_condition", "Y");

        Call<Example> call = apiService.createFactoryApi().signup(headerMap, params);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("SignupResponse", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        signup.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        signup.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    signup.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                signup.setValue(null);
                Log.e("SignupResponse", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });
        return signup;
    }

    private MutableLiveData<Result> verify_otp = new MutableLiveData<>();

    public MutableLiveData<Result> verify_otp(Context context,String num,String otp) {
        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);

        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", num);
        params.put("users_mobile_verification_code", otp);

        Call<Example> call = apiService.createFactoryApi().step_verification(headerMap, params);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("Step_verify", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        verify_otp.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        verify_otp.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    verify_otp.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                verify_otp.setValue(null);
                Log.e("Step_verify", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });
        return verify_otp;
    }

    private MutableLiveData<Result> home_details = new MutableLiveData<>();

    public MutableLiveData<Result> home_details(Context context) {
        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);

        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtils.getStringValue(context,PreferenceUtils.Userid));


        Call<Example> call = apiService.createFactoryApi().home_details(headerMap, params);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("home_details", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        home_details.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        home_details.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    home_details.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                home_details.setValue(null);
                Log.e("home_details", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });
        return home_details;
    }

    private MutableLiveData<Result> sub_cat_type = new MutableLiveData<>();

    public MutableLiveData<Result> sub_cat_type(Context context) {
        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);

        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtils.getStringValue(context,PreferenceUtils.Userid));
        params.put("category_id",PreferenceUtils.getStringValue(context,PreferenceUtils.Cat_id));


        Call<Example> call = apiService.createFactoryApi().sub_cat_type(headerMap, params);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("sub_cat_type", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        sub_cat_type.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        sub_cat_type.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    sub_cat_type.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                sub_cat_type.setValue(null);
                Log.e("sub_cat_type", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });
        return sub_cat_type;
    }

    private MutableLiveData<Result> view_all = new MutableLiveData<>();

    public MutableLiveData<Result> view_all(Context context) {
        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);
        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtils.getStringValue(context,PreferenceUtils.Userid));


        Call<Example> call = apiService.createFactoryApi().view_all(headerMap, params);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("view_all", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        view_all.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        view_all.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    view_all.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                view_all.setValue(null);
                Log.e("view_all", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });
        return view_all;
    }

    private MutableLiveData<Result> hosp_list = new MutableLiveData<>();

    public MutableLiveData<Result> hosp_list(Context context) {
        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);

        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtils.getStringValue(context,PreferenceUtils.Userid));

        Call<Example> call = apiService.createFactoryApi().hosp_list(headerMap, params);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("hosp_list", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        hosp_list.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        hosp_list.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    hosp_list.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                hosp_list.setValue(null);
                Log.e("hosp_list", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });
        return hosp_list;
    }

    private MutableLiveData<Result> hos_des = new MutableLiveData<>();

    public MutableLiveData<Result> hos_des(Context context,String hos_id) {
        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);

        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtils.getStringValue(context,PreferenceUtils.Userid));
        params.put("hospital_id",hos_id);

        Call<Example> call = apiService.createFactoryApi().hosp_des(headerMap, params);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("hos_des", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        hos_des.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        hos_des.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    hos_des.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                hos_des.setValue(null);
                Log.e("hos_des", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });
        return hos_des;
    }

    private MutableLiveData<Result> doc_list = new MutableLiveData<>();

    public MutableLiveData<Result> doc_list(Context context) {
        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);

        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtils.getStringValue(context,PreferenceUtils.Userid));

        Call<Example> call = apiService.createFactoryApi().doc_list(headerMap, params);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("doc_list", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        doc_list.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        doc_list.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    doc_list.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                doc_list.setValue(null);
                Log.e("doc_list", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });
        return doc_list;
    }

    private MutableLiveData<Result> sup_list = new MutableLiveData<>();

    public MutableLiveData<Result> sup_list(Context context) {
        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);

        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtils.getStringValue(context,PreferenceUtils.Userid));

        Call<Example> call = apiService.createFactoryApi().sup_list(headerMap, params);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("sup_list", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        sup_list.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        sup_list.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    sup_list.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                doc_list.setValue(null);
                Log.e("sup_list", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });
        return sup_list;
    }

    private MutableLiveData<Result> doc_des = new MutableLiveData<>();

    public MutableLiveData<Result> doc_des(Context context,String doc_id) {
        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);

        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtils.getStringValue(context,PreferenceUtils.Userid));
        params.put("doctor_id",doc_id);

        Call<Example> call = apiService.createFactoryApi().doc_des(headerMap, params);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("doc_des", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        doc_des.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        doc_des.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    doc_des.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                doc_des.setValue(null);
                Log.e("doc_des", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });
        return doc_des;
    }

    private MutableLiveData<Result> book_app = new MutableLiveData<>();

    public MutableLiveData<Result> book_app(Context context,String doc_id,String fee,String date, String time) {
        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);

        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtils.getStringValue(context,PreferenceUtils.Userid));
        params.put("doctor_id",doc_id);
        params.put("appointment_date",date);
        params.put("fees",fee);
        params.put("appointment_time",time);

        Call<Example> call = apiService.createFactoryApi().book_app(headerMap, params);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("book_app", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        book_app.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        book_app.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    book_app.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                book_app.setValue(null);
                Log.e("book_app", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });
        return book_app;
    }

    private MutableLiveData<Result> sub_rating = new MutableLiveData<>();

    public MutableLiveData<Result> sub_rating(Context context,String doc_id,Float rating) {
        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);

        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtils.getStringValue(context,PreferenceUtils.Userid));
        params.put("doctor_id",doc_id);
        params.put("rating", String.valueOf(rating));


        Call<Example> call = apiService.createFactoryApi().sub_rating(headerMap, params);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("sub_rating", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        sub_rating.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        sub_rating.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    sub_rating.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                sub_rating.setValue(null);
                Log.e("sub_rating", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });
        return sub_rating;
    }

    private MutableLiveData<Result> hos_sub_rating = new MutableLiveData<>();

    public MutableLiveData<Result> hos_sub_rating(Context context,String hos_id,Float rating) {
        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);

        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtils.getStringValue(context,PreferenceUtils.Userid));
        params.put("hospital_id",hos_id);
        params.put("rating", String.valueOf(rating));


        Call<Example> call = apiService.createFactoryApi().hos_id(headerMap, params);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("hos_sub_rating", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        hos_sub_rating.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        hos_sub_rating.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    hos_sub_rating.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                hos_sub_rating.setValue(null);
                Log.e("hos_sub_rating", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });
        return hos_sub_rating;
    }

    private MutableLiveData<Result> shopp_cart = new MutableLiveData<>();

    public MutableLiveData<Result> shopp_cart(Context context) {
        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);

        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtils.getStringValue(context,PreferenceUtils.Userid));



        Call<Example> call = apiService.createFactoryApi().shopp_cart(headerMap, params);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("shopp_cart", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        shopp_cart.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        shopp_cart.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    shopp_cart.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                shopp_cart.setValue(null);
                Log.e("shopp_cart", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });
        return shopp_cart;
    }

    private MutableLiveData<Result> shopp_cart_des = new MutableLiveData<>();

    public MutableLiveData<Result> shopp_cart_des(Context context,String subcat_id) {
        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);

        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtils.getStringValue(context,PreferenceUtils.Userid));
        params.put("shop_sub_category_id",subcat_id);

        Call<Example> call = apiService.createFactoryApi().shopp_cart_des(headerMap, params);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("shopp_cart_des", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        shopp_cart_des.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        shopp_cart_des.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    shopp_cart_des.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                shopp_cart_des.setValue(null);
                Log.e("shopp_cart_des", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });
        return shopp_cart_des;
    }

    private MutableLiveData<Result> add_cart = new MutableLiveData<>();

    public MutableLiveData<Result> add_cart(Context context,String prod_id) {
        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);

        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtils.getStringValue(context,PreferenceUtils.Userid));
        params.put("product_id",prod_id);

        Call<Example> call = apiService.createFactoryApi().add_cart(headerMap, params);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("add_cart", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        add_cart.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        add_cart.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    add_cart.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                add_cart.setValue(null);
                Log.e("add_cart", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return add_cart;
    }

    private MutableLiveData<Result> add_fav = new MutableLiveData<>();

    public MutableLiveData<Result> add_fav(Context context) {
        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);

        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtils.getStringValue(context,PreferenceUtils.Userid));
        params.put("sub_category_id",PreferenceUtils.getStringValue(context,PreferenceUtils.Sub_Cat_id));

        Call<Example> call = apiService.createFactoryApi().add_fav(headerMap, params);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("add_fav", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        add_fav.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        add_fav.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    add_fav.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                add_fav.setValue(null);
                Log.e("add_fav", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return add_fav;
    }

    private MutableLiveData<Result> des_type = new MutableLiveData<>();

    public MutableLiveData<Result> des_type(Context context) {
        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);

        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtils.getStringValue(context,PreferenceUtils.Userid));
        params.put("sub_category_id",PreferenceUtils.getStringValue(context,PreferenceUtils.Sub_Cat_id));

        Call<Example> call = apiService.createFactoryApi().des_type(headerMap, params);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("des_type", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        des_type.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        des_type.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    des_type.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                des_type.setValue(null);
                Log.e("des_type", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return des_type;
    }

    private MutableLiveData<Result> get_cart = new MutableLiveData<>();

    public MutableLiveData<Result> get_cart(Context context) {
        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);

        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtils.getStringValue(context,PreferenceUtils.Userid));

        Call<Example> call = apiService.createFactoryApi().get_cart(headerMap, params);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("get_cart", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        get_cart.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        get_cart.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    get_cart.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                get_cart.setValue(null);
                Log.e("get_cart", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return get_cart;
    }

    private MutableLiveData<Result> buy_now = new MutableLiveData<>();

    public MutableLiveData<Result> buy_now(Context context,String prod_id) {
        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);

        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtils.getStringValue(context,PreferenceUtils.Userid));
        params.put("product_id",prod_id);

        Call<Example> call = apiService.createFactoryApi().buy_now(headerMap, params);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("buy_now", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        buy_now.setValue(response.body().getResult());
                      //  Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        buy_now.setValue(null);
                     //   Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    buy_now.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                buy_now.setValue(null);
                Log.e("buy_now", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return buy_now;
    }

    private MutableLiveData<Result> cart_buy_now = new MutableLiveData<>();

    public MutableLiveData<Result> cart_buy_now(Context context) {
        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);

        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtils.getStringValue(context,PreferenceUtils.Userid));

        Call<Example> call = apiService.createFactoryApi().cart_buy_now(headerMap, params);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("cart_buy_now", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        cart_buy_now.setValue(response.body().getResult());
                      //  Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        cart_buy_now.setValue(null);
                       // Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    cart_buy_now.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                cart_buy_now.setValue(null);
                Log.e("cart_buy_now", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return cart_buy_now;
    }

    private MutableLiveData<Result> place_order = new MutableLiveData<>();

    public MutableLiveData<Result> place_order(Context context,String payment_mode) {
        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);

        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtils.getStringValue(context,PreferenceUtils.Userid));
        params.put("order_id",PreferenceUtils.getStringValue(context,PreferenceUtils.Order_id));
        params.put("payment_mode",payment_mode);

        Call<Example> call = apiService.createFactoryApi().place_order(headerMap, params);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("place_order", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        place_order.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        place_order.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    place_order.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                place_order.setValue(null);
                Log.e("place_order", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return place_order;
    }

    private MutableLiveData<Result> profile = new MutableLiveData<>();

    public MutableLiveData<Result> profile(Context context, String user_name, String phone_no, String email, String address, List<MultipartBody.Part> files) {
        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);

        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtils.getStringValue(context,PreferenceUtils.Userid));
        params.put("users_name", user_name);
        params.put("users_email", email);
        params.put("users_mobile",phone_no);
        params.put("users_address", address);



        Call<Example> call = apiService.createFactoryApi().profile(headerMap, params,files);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("profile", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        profile.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        profile.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    profile.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                profile.setValue(null);
                Log.e("profile", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return profile;
    }

    private MutableLiveData<Result> order_list = new MutableLiveData<>();

    public MutableLiveData<Result> order_list(Context context) {
        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);

        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtils.getStringValue(context,PreferenceUtils.Userid));


        Call<Example> call = apiService.createFactoryApi().order_list(headerMap, params);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("order_list", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        order_list.setValue(response.body().getResult());
                       // Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        order_list.setValue(null);
                        //Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    order_list.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                order_list.setValue(null);
                Log.e("order_list", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return order_list;
    }

    private MutableLiveData<Result> logout = new MutableLiveData<>();

    public MutableLiveData<Result> logout(Context context) {
        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);

        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtils.getStringValue(context,PreferenceUtils.Userid));


        Call<Example> call = apiService.createFactoryApi().logout(headerMap, params);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("logout", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        logout.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        logout.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    logout.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                logout.setValue(null);
                Log.e("logout", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return logout;
    }

    private MutableLiveData<Result> about = new MutableLiveData<>();

    public MutableLiveData<Result> about(Context context) {
        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);

        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtils.getStringValue(context,PreferenceUtils.Userid));

        Call<Example> call = apiService.createFactoryApi().about(headerMap, params);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("about", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        about.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        about.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    about.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                about.setValue(null);
                Log.e("about", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return about;
    }

    private MutableLiveData<Result> disclaimer = new MutableLiveData<>();

    public MutableLiveData<Result> disclaimer(Context context) {
        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);

        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtils.getStringValue(context,PreferenceUtils.Userid));

        Call<Example> call = apiService.createFactoryApi().disclaimer(headerMap, params);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("disclaimer", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        disclaimer.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        disclaimer.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    disclaimer.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                disclaimer.setValue(null);
                Log.e("disclaimer", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return disclaimer;
    }

    private MutableLiveData<Result> termsConditions = new MutableLiveData<>();

    public MutableLiveData<Result> termsConditions(Context context) {
        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);

        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtils.getStringValue(context,PreferenceUtils.Userid));

        Call<Example> call = apiService.createFactoryApi().termsConditions(headerMap, params);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("termsConditions", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        termsConditions.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        termsConditions.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    termsConditions.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                termsConditions.setValue(null);
                Log.e("termsConditions", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return termsConditions;
    }

    private MutableLiveData<Result> privacypolicy = new MutableLiveData<>();

    public MutableLiveData<Result> privacypolicy(Context context) {
        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);

        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtils.getStringValue(context,PreferenceUtils.Userid));

        Call<Example> call = apiService.createFactoryApi().privacypolicy(headerMap, params);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("privacypolicy", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        privacypolicy.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        privacypolicy.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    privacypolicy.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                privacypolicy.setValue(null);
                Log.e("termsConditions", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return privacypolicy;
    }

    private MutableLiveData<Result> partners = new MutableLiveData<>();

    public MutableLiveData<Result> partners(Context context) {
        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);

        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtils.getStringValue(context,PreferenceUtils.Userid));

        Call<Example> call = apiService.createFactoryApi().partners(headerMap, params);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("partners", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        partners.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        partners.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    partners.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                partners.setValue(null);
                Log.e("partners", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return partners;
    }

    private MutableLiveData<Result> get_fav = new MutableLiveData<>();

    public MutableLiveData<Result> get_fav(Context context) {
        ApiService apiService = ApiService.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(context);

        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtils.getStringValue(context,PreferenceUtils.Userid));

        Call<Example> call = apiService.createFactoryApi().get_fav(headerMap, params);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("get_fav", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        get_fav.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        get_fav.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    get_fav.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                get_fav.setValue(null);
                Log.e("get_fav", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return get_fav;
    }


}
