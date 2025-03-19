package com.flow.platform.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当前时间
     */
    public static String getCurrentTime() {
        return formatDate(new Date());
    }

    /**
     * 格式化日期
     */
    public static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        return sdf.format(date);
    }

    /**
     * 解析日期字符串
     */
    public static Date parseDate(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
            return sdf.parse(dateStr);
        } catch (Exception e) {
            throw new RuntimeException("日期解析失败: " + dateStr, e);
        }
    }
}