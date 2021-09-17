package com.yuanian.encry.utils;

import java.util.UUID;

/**
 * UUID工具类
 * @author zhahsh
 * @date 2021/9/17
 */
public class UUIDUtils {
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    public static String getRandomNumber() {
        return String.valueOf(DateUtils.getTimestamp()) + (int)((Math.random()*9+1)*100000);
    }
}
