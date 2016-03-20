package com.github.zouzhberk.essence.rxwe.features;


import com.github.zouzhberk.essence.rxwe.domain.ServerAddressesEntity;
import com.github.zouzhberk.essence.rxwe.domain.TokenEntity;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


/**
 * Created by berk on 3/12/16.
 */
public interface BaseSupportApi {

    @GET("/cgi-bin/token")
    public Observable<TokenEntity> getToken(@Query("grant_type") String grantType, @Query("appid") String appid,
                                            @Query("secret") String secret);

    @GET("/cgi-bin/getcallbackip")
    public Observable<ServerAddressesEntity> getServerIPs(@Query("access_token") String accessToken);
}
