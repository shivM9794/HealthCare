package com.healthcare.app.Utility;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;

import java.util.HashMap;

public class PreferenceUtils {

    public static final String FCMTOKEN = "TGP_FCM_TOKEN";
    public static final String Userid = "TGP_Userid";
    public static final String Orderid = "TGP_Orderid";
    public static final String Name = "TGP_Name";
    public static final String mobile = "TGP_mobile";
    public static final String email = "TGP_email";
    public static final String address = "TGP_address";
    public static final String Cat_id = "TGP_Cat_id";
    public static final String Fav="TGP_Fav";
    public static final String Profile="TGP_Profile";
    public static final String Profile_Updated="Profile_Updated";
    public static final String New_User="New_User";
    public static final String Order_id = "TGP_Order_id";
    public static final String Sub_Cat_id = "TGP_sub_Cat_id";

    public static final String Login= "TGP_Login";
    public static final String LoginType= "TGP_LoginType";




    public static boolean getBoolValue(Context context, String key) {
        int mode = Activity.MODE_PRIVATE;
        SharedPreferences sp = context.getSharedPreferences(key, mode);
        return sp.getBoolean(key, false);
    }

    public static void setBoolValue( Context context, String key, Boolean ip) {
        int mode = Activity.MODE_PRIVATE;
        SharedPreferences sp = context.getSharedPreferences(key, mode);
        SharedPreferences.Editor e = sp.edit();
        e.putBoolean(key, ip);
        e.apply();
    }

    public static String getStringValue(Context context, String key) {
        int mode = Activity.MODE_PRIVATE;
        SharedPreferences sp = context.getSharedPreferences(key, mode);
        return sp.getString(key, "0");
    }

    public static void setStringValue(Context context, String key, String ip) {
        int mode = Activity.MODE_PRIVATE;
        SharedPreferences sp = context.getSharedPreferences(key, mode);
        SharedPreferences.Editor e = sp.edit();
        e.putString(key, ip);
        e.apply();
    }

    public static HashMap<String, String> getHeaderMap(Context context) {
        HashMap<String, String> header = new HashMap<>();
        header.put("Apikey", "7197ca96b6dd890243486cf2b8288ca9");
        header.put("Apidate", "2021-11-08");
        header.put("Apilanguage", "en");
        header.put("Apitimezone", "Asia/Kolkata");
        header.put("Apidevicetype", "Android");
        header.put("Apidevicelat", "");
        header.put("Apidevicelong", "");
        header.put("Apideviceid", getStringValue(context, FCMTOKEN));
        header.put("Apicurrdate", KeyGenerationClass.getDate());
        header.put("Apicurrtime", "1602745108");
        header.put("Apitoken","");


        Log.e("Apikey", KeyGenerationClass.getEncryptedKey());
        Log.e("Apidate", KeyGenerationClass.getDate());
        Log.e("Apilanguage", "en");
        Log.e("Apitimezone", "Asia/Dubai");
        Log.e("Apidevicetype", "Android");
        Log.e("Apidevicelat", "");
        Log.e("Apidevicelong", "");
        Log.e("Apideviceid", getStringValue(context, FCMTOKEN));
        Log.e("Apicurrdate", KeyGenerationClass.getDate());
        Log.e("Apicurrtime", "1602745108");
        Log.e("Apicurrency" ,"AED");
        Log.e("Apitoken","");
        Log.e("Apicurrencyvalue" ,"1.0000");

        return header;
    }

    public static boolean isNetworkAvailable(Context context) {
        try {
            final ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            if (cm != null) {
                if (Build.VERSION.SDK_INT < 23) {
                    final NetworkInfo ni = cm.getActiveNetworkInfo();

                    if (ni != null) {
                        return (ni.isConnected() && (ni.getType() == ConnectivityManager.TYPE_WIFI || ni.getType() == ConnectivityManager.TYPE_MOBILE));
                    }
                } else {
                    final Network n = cm.getActiveNetwork();
                    if (n != null) {
                        final NetworkCapabilities nc = cm.getNetworkCapabilities(n);
                        return (nc.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || nc.hasTransport(NetworkCapabilities.TRANSPORT_WIFI));
                    }
                }
            }

            return false;

        } catch (Exception e) {
            return true;
        }
    }

}
