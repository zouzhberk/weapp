package com.github.zouzhberk.essence.rxweather;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

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

    private RxWeather() {
        retrofit = new Retrofit.Builder().addConverterFactory
                (JacksonConverterFactory
                        .create())
                .baseUrl(baseUrl == null ? "https://api.heweather.com/x3/" : null)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public <T> T create(Class<T> featureApi) {
        return retrofit.create(featureApi);
    }
}
