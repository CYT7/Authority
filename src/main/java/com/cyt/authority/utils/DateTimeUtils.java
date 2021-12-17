package com.cyt.authority.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Chenyt7
 * @Time 2021/5/20
 * @describe: 日期时间相关工具
 **/
public class DateTimeUtils {
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**获取当前标准格式化日期时间*/
    public static String getDateTime() {
        return getDateTime(new Date());
    }
    /**标准格式化日期时间*/
    public static String getDateTime(Date date) {
        return (new SimpleDateFormat(DATE_FORMAT)).format(date);
    }
}
