package com.cyt.authority.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author Chenyt7
 * @date  2021/5/26
 * @describe HTTP工具类
 **/
public class HttpUtils {
    /**获取HttpServletRequest对象*/
    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }
}