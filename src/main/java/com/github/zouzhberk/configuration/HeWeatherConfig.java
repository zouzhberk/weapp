package com.github.zouzhberk.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by berk on 3/22/16.
 */

@Component
@ConfigurationProperties(prefix = "weather")
public class HeWeatherConfig {

    private String key;

    public String getBaseurl() {
        return baseurl;
        //return baseurl;
    }

    public void setBaseurl(String baseurl) {
        this.baseurl = baseurl;
    }

    private String baseurl;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "HeWeatherConfig{" +
                "key='" + key + '\'' +
                ", baseurl='" + baseurl + '\'' +
                '}';
    }
}
