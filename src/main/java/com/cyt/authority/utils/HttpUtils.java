package com.cyt.authority.utils;

import com.cyt.authority.core.http.HttpResult;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Chenyt7
 * @Time 2021/5/26
 * @describe:HTTP工具类
 **/
public class HttpUtils {
    //获取HttpServletRequest对象
    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
    //输出信息到浏览器
    public static void print(HttpServletResponse response, int code, String msg) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        HttpResult result = HttpResult.error(code, msg);
        String json = JSONObject.toJSONString(result);
        response.getWriter().print(json);
        response.getWriter().flush();
        response.getWriter().close();
    }
}