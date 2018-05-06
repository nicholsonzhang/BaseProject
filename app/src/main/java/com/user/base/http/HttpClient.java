package com.user.base.http;


import com.base.library.http.RetrofitHelper;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 2017/8/10.
 */

public class HttpClient {


    private static volatile HttpClient sInstance;

    private RequestApi requestApi;
    private HttpClient(){

        requestApi =RetrofitHelper.getInstance().create(RequestApi.class);
    }

    public static HttpClient getInstance(){
        if (sInstance == null){
            synchronized (HttpClient.class){
                if (sInstance == null){
                    sInstance = new HttpClient();
                }
            }
        }
        return sInstance;
    }






}
