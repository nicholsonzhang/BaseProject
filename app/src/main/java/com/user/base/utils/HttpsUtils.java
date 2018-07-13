package com.user.base.utils;

import android.support.annotation.Nullable;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class HttpsUtils {

    public static class SSLParams {
        public SSLSocketFactory sslSocketFactory;
        public X509TrustManager x509TrustManager;
    }

    public static SSLParams getSSLSocketFactory(InputStream... certificates) {
        return getSSLSocketParams(null, certificates);

    }

    public static SSLParams getSSLSocketFactory(X509TrustManager trustManager, InputStream... certificates) {
        return getSSLSocketParams(trustManager, certificates);
    }

    private static SSLParams getSSLSocketParams(X509TrustManager customTrustManager, InputStream... certificates) {

        SSLParams sslParams = new SSLParams();
        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            TrustManager[] trustManagers = getTrustManagers(certificates);
            X509TrustManager manager;
            if (customTrustManager != null) {
                manager = customTrustManager;
            } else if (trustManagers != null) {
                manager = chooseTrustManager(trustManagers);
            } else {
                manager = unSafeTrustManager;
            }
            sslContext.init(null, new TrustManager[]{manager}, new SecureRandom());

            sslParams.sslSocketFactory = sslContext.getSocketFactory();
            sslParams.x509TrustManager = manager;
            return sslParams;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static TrustManager[] getTrustManagers(InputStream... certificates) {
        if (certificates == null || certificates.length == 0) return null;
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            int index = 0;
            for (InputStream certificateStream : certificates) {
                String alias = String.valueOf(index++);
                Certificate certificate = certificateFactory.generateCertificate(certificateStream);
                keyStore.setCertificateEntry(alias, certificate);

                try {
                    if (certificateStream != null) {
                        certificateStream.close();
                    }
                } catch (Exception e) {

                }
            }
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            return trustManagerFactory.getTrustManagers();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static X509TrustManager chooseTrustManager(TrustManager[] trustManagers) {
        if (trustManagers == null) return null;
        for (TrustManager trustManager : trustManagers) {
            if (trustManager instanceof X509TrustManager) {
                return (X509TrustManager) trustManager;
            }
        }
        return null;
    }

    private static X509TrustManager unSafeTrustManager = new X509TrustManager() {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    };


}
