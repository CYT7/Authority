package com.cyt.authority.utils;

/**
 * @author Chenyt7
 * @date 2021/5/20
 * @describe 字符串工具类
 **/
public class StringUtils {
    /**判空操作*/
    public static boolean isBlank(String value) {
        return value == null || "".equals(value) || "null".equals(value) || "undefined".equals(value);
    }
}