package com.rapis.util;

/**
 * @author siboran
 * @create 2022/2/18
 */
public final class RedisKeyUtil {
    private static final String SPLIT = ":";
    private static final String PREFIX_TOKEN = "token";

    // 登录的凭证
    public static String getTOKENKey(String token) {
        return PREFIX_TOKEN + SPLIT + token;
    }
}
