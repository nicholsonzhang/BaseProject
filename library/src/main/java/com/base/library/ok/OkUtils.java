package com.base.library.ok;



import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkUtils {


    private OkUtils() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(loggingInterceptor);


        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20,TimeUnit.SECONDS);


    }


    public static OkUtils getInstance() {
        return OkUtilsHolder.holder;
    }

    private static class OkUtilsHolder {
        private static OkUtils holder = new OkUtils();
    }

    public String test(){
        return "this is test";
    }


}
