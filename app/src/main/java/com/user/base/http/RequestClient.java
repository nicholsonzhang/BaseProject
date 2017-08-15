package com.user.base.http;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 2017/8/10.
 */

public class RequestClient {

    private RequestApi requestApi;


    private RequestClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")
                .client(OkHttpClientFactory.getInstance().getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        requestApi = retrofit.create(RequestApi.class);
    }



}
