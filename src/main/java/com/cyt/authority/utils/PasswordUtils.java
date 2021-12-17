package com.cyt.authority.utils;

import java.util.UUID;

/**
 * @author Chenyt7
 * @date  2021/5/20/12:36
 * @version 1.0.0
 * @describe 密码工具类
 **/
public class PasswordUtils {
    /**
     * 匹配密码
     * @param salt 盐
     * @param rawPass 明文
     * @param encPass 密文
     */
    public static boolean matchPassword(String salt, String rawPass, String encPass) {
        return new PasswordEncoder(salt).passwordMatching(encPass, rawPass);
    }
    /**
     * 明文密码加密
     * @param rawPass 明文
     * @param salt 盐
     */
    public static String encode(String rawPass, String salt) {
        return new PasswordEncoder(salt).encode(rawPass);
    }
    /**获取加密盐*/
    public static String getSalt() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
    }
}
