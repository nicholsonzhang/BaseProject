package com.user.base.http;


import com.base.library.http.BaseResponseBody;
import com.base.library.utils.RxUtils;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 2017/8/10.
 */

public class HttpClient {


    private static volatile HttpClient sInstance;

    private HttpService httpService;

    private HttpClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .client(OkHttpClientUtils.getInstance().getClient(null, null))
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        httpService =retrofit.create(HttpService.class);
    }

    public static HttpClient getInstance() {
        if (sInstance == null) {
            synchronized (HttpClient.class) {
                if (sInstance == null) {
                    sInstance = new HttpClient();
                }
            }
        }
        return sInstance;
    }

    public <T> Flowable<T> transformer(Observable<BaseResponseBody<T>> observable) {
        return observable.compose(RxUtils.<BaseResponseBody<T>>applySchedulers())
                .compose(RxUtils.<T>extractResult())
                .toFlowable(BackpressureStrategy.BUFFER);
    }


    public Flowable<String> testUserInfo(String key) {
        return transformer(httpService.testInfo(key));
    }


}
