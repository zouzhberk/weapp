package com.github.zouzhberk.utils;


import org.apache.commons.codec.digest.DigestUtils;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by berk on 3/20/16.
 */
public class WeUtils {

    public static String generateSignature(String token, String timestamp, String nonce) {
        return DigestUtils.sha1Hex(Stream.of(token, timestamp, nonce).sorted().collect(Collectors.joining()));
    }
}
