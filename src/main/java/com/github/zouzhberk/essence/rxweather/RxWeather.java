package com.github.zouzhberk.essence.rxweather;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

/**
 * Created by berk (zouzhberk@163.com)) on 3/23/16.
 */
public class RxWeather {
    private final Retrofit retrofit;
    private String baseUrl;

    public static class Builder {
        private String baseUrl;


        public static Builder baseUrl(String baseUrl) {
            Builder builder = new Builder();
            builder.baseUrl = baseUrl;
            return builder;
        }

        public RxWeather build() {
            RxWeather we = new RxWeather();
            we.baseUrl = baseUrl;
            return we;
        }
    }

    public OkHttpClient getSSLHttpClient() {

        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        try {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            InputStream instream = getClass().getResourceAsStream("api.heweather.com.crt");
            Certificate ca;
            ca = cf.generateCertificate(instream);
            KeyStore kStore = KeyStore.getInstance(KeyStore.getDefaultType());
            kStore.load(null, null);
            kStore.setCertificateEntry("ca", ca);
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(kStore);
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tmf.getTrustManagers(), null);
            okHttpClientBuilder.sslSocketFactory(sslContext.getSocketFactory());
        } catch (CertificateException
                | KeyStoreException
                | NoSuchAlgorithmException
                | IOException
                | KeyManagementException e) {
            e.printStackTrace();
        }
        return okHttpClientBuilder.build();
    }

    private RxWeather() {
        retrofit = new Retrofit.Builder().client(getSSLHttpClient()).addConverterFactory
                (JacksonConverterFactory
                        .create())
                .baseUrl(baseUrl == null ? "http://api.heweather.com/" : null)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public <T> T create(Class<T> featureApi) {
        return retrofit.create(featureApi);
    }

}
