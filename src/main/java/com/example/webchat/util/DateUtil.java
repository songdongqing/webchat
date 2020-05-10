package com.example.webchat.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author:   chenfeiliang
 * Description:
 */
public class DateUtil {
    public static String getStringDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        return dateString;
    }

    public static void main(String[] args) {
        System.out.println(getStringDate(new Date()));
    }
}