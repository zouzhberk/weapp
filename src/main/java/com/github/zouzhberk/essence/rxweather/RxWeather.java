package com.github.zouzhberk.essence.rxweather;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by berk (zouzhberk@163.com)) on 3/23/16.
 */
public class RxWeather
{
    public <T> T create(Class<T> featureApi)
    {
        String baseUrl = "https://api.heweather.com/x3/";
        Retrofit retrofit = new Retrofit.Builder().addConverterFactory
                (JacksonConverterFactory
                .create())
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(featureApi);
    }
}
