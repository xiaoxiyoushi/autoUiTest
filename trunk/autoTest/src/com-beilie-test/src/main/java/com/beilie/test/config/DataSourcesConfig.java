package com.beilie.test.config;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DataSourcesConfig {
	
	@Value("${spring.datasource.driver-class-name}")
	String driverClass;
	@Value("${spring.datasource.url}")
	String url;
	@Value("${spring.datasource.username}")
	String userName;
	@Value("${spring.datasource.password}")
	String passWord;
	@Value("${spring.datasource.type}")
	String type;
	@Value("${spring.datasource.filters}")
	String filters;
	@Value("${spring.datasource.maxActive}")
	Integer maxActive;
	@Value("${spring.datasource.initialSize}")
	Integer initialSize;
	@Value("${spring.datasource.maxWait}")
	Long maxWait;
	@Value("${spring.datasource.minIdle}")
	Integer minIdle;
	@Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
	Long timeBetweenEvictionRunsMillis;
	@Value("${spring.datasource.minEvictableIdleTimeMillis}")
	Long minEvictableIdleTimeMillis;
	@Value("${spring.datasource.validationQuery}")
	String validationQuery;
	@Value("${spring.datasource.testWhileIdle}")
	Boolean testWhileIdle;
	@Value("${spring.datasource.testOnBorrow}")
	Boolean testOnBorrow;
	@Value("${spring.datasource.testOnReturn}")
	Boolean testOnReturn;
	@Value("${spring.datasource.poolPreparedStatements}")
	Boolean poolPreparedStatements;
	@Value("${spring.datasource.maxOpenPreparedStatements}")
	Integer maxOpenPreparedStatements;
		
	@Primary 
	@Bean(name = "dataSource",destroyMethod = "close")
	public DruidDataSource Construction() throws SQLException {
	    DruidDataSource dataSource = new DruidDataSource();
	    dataSource.setUrl(url);
	    dataSource.setUsername(userName);
	    dataSource.setPassword(passWord);
	    dataSource.setDriverClassName(driverClass);
	    dataSource.setMaxActive(maxActive);
	    dataSource.setInitialSize(initialSize);
	    dataSource.setMinIdle(minIdle);
	    dataSource.setMaxWait(maxWait);
	    dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
	    dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
	    dataSource.setValidationQuery(validationQuery);
	    dataSource.setTestWhileIdle(testWhileIdle);
	    dataSource.setTestOnBorrow(testOnBorrow);
	    dataSource.setTestOnReturn(testOnReturn);
	    dataSource.setPoolPreparedStatements(poolPreparedStatements);
	    dataSource.setMaxOpenPreparedStatements(maxOpenPreparedStatements);
	    dataSource.setFilters("stat,wall,log4j");
	    try {
	        dataSource.init();
	    } catch (SQLException e) {
	        throw new RuntimeException("druid datasource init fail");
	    }
	    return dataSource;
	}
}