package com.study.configuration;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author xsy
 * @date 2021-02-22 1:30 下午
 */
@Component
public class DataSourceConfig {
    @Bean(name = "defaultDataSource")
    @ConfigurationProperties("spring.datasource.druid.study")
    public DataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }
}
