package com.github.zouzhberk.essence.rxwe;

import com.github.zouzhberk.essence.rxwe.features.BaseSupportApi;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by berk on 3/12/16.
 */
public class RxWe {
    private static final String WEIXIN_API_SERVER_URL = "https://api.weixin.qq.com/";
    private String baseUrl;

    public static class Builder {
        private String baseUrl;

        public Builder baseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }


        public static Builder builder() {
            return new Builder();
        }

        public RxWe build() {
            RxWe we = new RxWe();
            we.baseUrl = baseUrl;
            return we;
        }
    }

    public <T> T create(Class<T> featureApi) {

        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(JacksonConverterFactory.create()).baseUrl
                (baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(featureApi);
    }

    public static void main(String[] args) {
        RxWe we = Builder.builder().baseUrl(WEIXIN_API_SERVER_URL).build();
        BaseSupportApi tokenApi = we.create(BaseSupportApi.class);

        String grant_type = "client_credential";
        String appid = "wx526d912d724d940e";
        String secret = "3c8f212c2fd54bdf32477f71e7375b86";

        tokenApi.getToken(grant_type, appid, secret).map(x -> {
            System.out.println(x);
            return x;
        })
                .flatMap(x -> tokenApi.getServerIPs(x.getAccessToken()))

                .toBlocking()
                .forEach(System
                        .out::println);


    }
}
