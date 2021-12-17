package com.cyt.authority.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

/**
 * @author Chenyt7
 * @date  2021/5/19
 * @describe 数据源属性
 **/
@Configuration
public class DruidDataSourceProperties {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")/*自动装配*/
    public DataSource getDataSource(){
        return new DruidDataSource();
    }
}