package com.user.base.http;

import android.util.Log;

import com.base.library.listener.OnProgressListener;
import com.user.base.utils.FileUtils;

import java.io.File;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FileDUClient {

    private static volatile FileDUClient sInstance;

    private FileDUService fileDUService;

    private FileDUClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(OkHttpClientUtils.getInstance().getClient(null, null))
                .baseUrl("http://wwww.baidu.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        fileDUService = retrofit.create(FileDUService.class);
    }

    public static FileDUClient getInstance() {
        if (sInstance == null) {
            synchronized (FileDUClient.class) {
                if (sInstance == null) {
                    sInstance = new FileDUClient();
                }
            }
        }
        return sInstance;
    }


    public void downloadFile(String downloadUrl, final File savedFile, final OnProgressListener onProgressListener) {
        if (savedFile == null) return;

        Retrofit retrofit = new Retrofit.Builder()
                .client(OkHttpClientUtils.getInstance().getClient(null, onProgressListener))
                .baseUrl("http://www.baidu.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        FileDUService fileDUService = retrofit.create(FileDUService.class);

        fileDUService.downloadFile(downloadUrl)
                .doOnNext(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        FileUtils.writeToFile(responseBody.byteStream(), savedFile);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("yyzhang","onSubscribe");

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                    Log.e("yyzhang","onNext");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.e("yyzhang","onComplete");

                        if (onProgressListener != null) {
                            onProgressListener.onComplete(savedFile);
                        }


                    }
                });


    }
}
