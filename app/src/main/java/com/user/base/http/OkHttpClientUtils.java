package com.user.base.http;

import android.support.annotation.Nullable;

import com.user.base.BuildConfig;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by user on 2017/8/11.
 *
 */

public class OkHttpClientUtils {
    private static volatile OkHttpClientUtils sInstance;
    private OkHttpClientUtils(){
    }

    public static OkHttpClientUtils getInstance(){
        if (sInstance == null){
            synchronized (OkHttpClientUtils.class){
                if (sInstance == null){
                    sInstance = new OkHttpClientUtils();
                }
            }
        }
        return sInstance;
    }
    public OkHttpClient getClient(@Nullable InputStream cert) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }

        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request request = originalRequest.newBuilder()
                        .method(originalRequest.method(), originalRequest.body())
                        .header("token", "custom get token")
                        .build();
//                Response originalResponse = chain.proceed(request);
//                return originalResponse.newBuilder()
//                        .body(new ProgressResponseBody(originalResponse.body(),mProgressResponseListener))
//                        .build();
                return chain.proceed(request);
            }
        };

        builder.addNetworkInterceptor(interceptor);
        builder.connectTimeout(15, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(true);

        if (cert != null) {
            setHttpsConfig(builder, cert);
        }


        return builder.build();
    }

    //配置https相关
    private void setHttpsConfig(OkHttpClient.Builder builder, InputStream cert) {
        try {

            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            Certificate certificate = certificateFactory.generateCertificate(cert);

            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            keyStore.setCertificateEntry("ca", certificate);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();

            if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                throw new IllegalStateException("Unexpected default trust managers:"
                        + Arrays.toString(trustManagers));
            }

            X509TrustManager x509TrustManager = (X509TrustManager) trustManagers[0];
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{x509TrustManager}, new SecureRandom());
            builder.sslSocketFactory(sslContext.getSocketFactory(), x509TrustManager);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
