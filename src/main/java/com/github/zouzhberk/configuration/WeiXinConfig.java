package com.github.zouzhberk.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by berk on 4/2/16.
 */
@Component
@ConfigurationProperties(prefix = "we")
public class WeiXinConfig {

    private String serverUrl;

    private String grantType;

    //    @Value("${appid}")
    private String appid;

    //    @Value("${secret}")
    private String secret;

    //    @Value("${token}")
    private String customToken;

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getCustomToken() {
        return customToken;
    }

    public void setCustomToken(String customToken) {
        this.customToken = customToken;
    }
}
