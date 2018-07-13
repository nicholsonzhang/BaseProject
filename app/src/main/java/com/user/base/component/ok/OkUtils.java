package com.user.base.component.ok;


import com.user.base.MyApplication;
import com.user.base.utils.HttpsUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkUtils {

    private static OkHttpClient mOkHttpClient;

    private OkUtils() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(loggingInterceptor);

        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        builder.connectTimeout(15, TimeUnit.SECONDS);


        Interceptor networkInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request request = originalRequest.newBuilder()
                        .method(originalRequest.method(), originalRequest.body())
                        .header("os", "android")
                        .header("token", "my token")
                        .build();
                return chain.proceed(request);
            }
        };

        builder.addNetworkInterceptor(networkInterceptor);
        InputStream cerStream = null;
        try {
            //TODO 使用的12306的公钥证书
            cerStream = MyApplication.getApplication().getAssets().open("srca.cer");
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpsUtils.SSLParams sslParams = HttpsUtils.getSSLSocketFactory(cerStream);
        builder.sslSocketFactory(sslParams.sslSocketFactory, sslParams.x509TrustManager);
        mOkHttpClient = builder.build();


    }


    public static OkUtils getInstance() {
        return OkUtilsHolder.holder;
    }

    private static class OkUtilsHolder {
        private static OkUtils holder = new OkUtils();
    }

    public OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }


}
