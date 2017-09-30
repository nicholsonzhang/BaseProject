package com.user.base.http;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 2017/8/10.
 */

public class RequestClient {
    private static volatile RequestClient mRequestClient;
    private RequestApi requestApi;


    private RequestClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")
                .client(OkHttpClientFactory.getInstance().getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        requestApi = retrofit.create(RequestApi.class);
    }

    public static RequestClient get() {
        if (mRequestClient == null) {
            synchronized (RequestClient.class) {
                if (mRequestClient == null) {
                    mRequestClient = new RequestClient();
                }
            }
        }
        return mRequestClient;
    }



}
