package com.user.base.http;

import com.user.base.BuildConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by user on 2017/8/11.
 *
 */

public class OkHttpClientFactory {
    private static volatile  OkHttpClientFactory mInstance;
    private OkHttpClient mClient;

    private OkHttpClientFactory(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG){
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }


        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest  = chain.request();
                Request request = originalRequest.newBuilder()
                        .method(originalRequest.method(),originalRequest.body())
                        .build();

                return chain.proceed(request);
            }
        };
        builder.addNetworkInterceptor(interceptor);
        builder.connectTimeout(15, TimeUnit.SECONDS);
        builder.readTimeout(20,TimeUnit.SECONDS);
        builder.writeTimeout(20,TimeUnit.SECONDS);


        mClient = builder.build();
    }

    public static OkHttpClientFactory getInstance(){
        if (mInstance == null){
            synchronized (OkHttpClientFactory.class){
                if (mInstance == null){
                    mInstance = new OkHttpClientFactory();
                }
            }
        }
        return mInstance;
    }
    public OkHttpClient getClient(){
        return mClient;
    }


}
