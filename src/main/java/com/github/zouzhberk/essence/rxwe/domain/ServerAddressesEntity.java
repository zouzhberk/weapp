package com.github.zouzhberk.essence.rxwe.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by berk on 3/12/16.
 */
public class ServerAddressesEntity extends ErrorEntity {
    @JsonProperty("ip_list")
    private List<String> ipAddresses;

    public List<String> getIpAddresses() {
        return ipAddresses;
    }

    public void setIpAddresses(List<String> ipAddresses) {
        this.ipAddresses = ipAddresses;
    }

    @Override
    public String toString() {
        return "ServerAddressesEntity{" +
                "ipAddresses=" + ipAddresses +
                '}';
    }
}
