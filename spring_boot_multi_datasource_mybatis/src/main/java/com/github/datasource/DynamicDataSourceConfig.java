package com.github.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 配置多数据源
 *
 * @author jared
 */
@Configuration
public class DynamicDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.druid.yum")
    public DataSource TXDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.local")
    public DataSource BQDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource TXDataSource, DataSource BQDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceNames.YUM, TXDataSource);
        targetDataSources.put(DataSourceNames.LOCAL, BQDataSource);
        return new DynamicDataSource(TXDataSource, targetDataSources);
    }
}
