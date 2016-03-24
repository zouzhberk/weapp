package com.github.zouzhberk.essence.rxweather;

import com.github.zouzhberk.essence.rxweather.features.WeatherApi;
import com.github.zouzhberk.utils.JsonUtils;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.stream.Stream;

/**
 * Created by berk (zouzhberk@163.com)) on 3/23/16.
 */
public class RxWeather
{
    private final Retrofit retrofit;
    private String baseUrl;

    public static class Builder
    {
        private String baseUrl;


        public static Builder baseUrl(String baseUrl)
        {
            Builder builder = new Builder();
            builder.baseUrl = baseUrl;
            return builder;
        }

        public RxWeather build()
        {
            RxWeather we = new RxWeather();
            we.baseUrl = baseUrl;
            return we;
        }
    }

    private RxWeather()
    {
        retrofit = new Retrofit.Builder().addConverterFactory
                (JacksonConverterFactory
                .create())
                .baseUrl(baseUrl == null ? "https://api.heweather.com/" : null)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public <T> T create(Class<T> featureApi)
    {
        return retrofit.create(featureApi);
    }

    public static void main(String[] args)
    {
        WeatherApi weather = Builder.baseUrl("https://api.heweather.com/")
                .build()
                .create(WeatherApi.class);
        String key = "00153ce0e2884aba9f121f2eaea06cc3";
        weather.getCityWeather("guangzhou", key)
                .toBlocking()
                .first()
                .values()
                .stream()
                .findFirst()
                .map(Stream::of)
                .orElseGet(Stream::empty)
                .map(JsonUtils::toJson)
                .forEach(System.out::println);
    }
}
