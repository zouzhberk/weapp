package com.github.zouzhberk.essence.rxweather.features;

import com.github.zouzhberk.essence.rxweather.domain.Cities;
import com.github.zouzhberk.essence.rxweather.domain.CityWeatherEntity;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by berk (zouzhberk@163.com)) on 3/23/16.
 */
public interface WeatherApi {


    @GET("/weather")
    public Observable<CityWeatherEntity> getCityWeather(@Query("cityid") String cityid, @Query("key") String key);

    @GET("/citylist")
    public Observable<Cities> listCityInfo(@Query("search") String search, @Query("key") String key);
}
