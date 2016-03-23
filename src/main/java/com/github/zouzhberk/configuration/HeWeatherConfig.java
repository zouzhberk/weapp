package com.github.zouzhberk.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by berk on 3/22/16.
 */

@ConfigurationProperties(prefix = "weather")
public class HeWeatherConfig {
    private String key;

    public String getBaseurl() {
        return baseurl;
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
}
