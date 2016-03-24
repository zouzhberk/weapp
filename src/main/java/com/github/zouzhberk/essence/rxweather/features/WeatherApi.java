package com.github.zouzhberk.essence.rxweather.features;

import com.github.zouzhberk.essence.rxweather.domain.Cities;
import com.github.zouzhberk.essence.rxweather.domain.CityWeatherEntity;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by berk (zouzhberk@163.com)) on 3/23/16.
 */
public interface WeatherApi
{


    @GET("/x3/weather")
    public Observable<CityWeatherEntity> getCityWeather(@Query("city") String
                                                                    city,
                                                        @Query("key") String
                                                                key);

    @GET("/x3/citylist")
    public Observable<Cities> listCityInfo(@Query("search") String search,
                                           @Query("key") String key);
}
