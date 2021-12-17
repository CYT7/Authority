package com.cyt.authority.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Chenyt7
 * @date  2021/5/19
 * @describe 跨域配置
 **/
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //允许跨域访问的路径 跨域访问的源 请求方法 预检间隔时间 头部设置 是否发送cookie
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .maxAge(168000)
                .allowedHeaders("*")
                .allowCredentials(true);
    }
    /**
     * 跨域配置后swagger2可能不能访问，需要增加如下配置
     * 原因: 不能访问的原因的swagger的内置接口被拦截器拦下来了，需要将swagger加到拦截器的排除列表中。
     **/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}