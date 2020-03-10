package com.example.webchat.constant;

/**
 * Author:   chenfeiliang
 * Description:
 */
public class RedisKey {

    public static  String MAIN_TYPE = "MAIN_TYPE:";

    public static String getMainType(String fromUserName) {
        return MAIN_TYPE+fromUserName;
    }
}