package com.chanshiyu.elskan.utils;

import org.springframework.util.Base64Utils;

import java.nio.charset.StandardCharsets;

/**
 * @author SHIYU
 * @date 2020/3/21 15:25
 * @description
 */
public class CodeUtil {

    private static final String MARK = "ELSKAN";

    public static String generate(String url) {
        String now = String.valueOf(System.currentTimeMillis());
        return Base64Utils.encodeToUrlSafeString((MARK + "#" + url + "#" + now).getBytes());
    }

    public static String getUrl(String code) {
        String decode = new String(Base64Utils.decodeFromUrlSafeString(code), StandardCharsets.UTF_8);
        String[] pairs = decode.split("#");
        return pairs[1];
    }

}
