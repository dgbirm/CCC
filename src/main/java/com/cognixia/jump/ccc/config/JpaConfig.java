package com.cognixia.jump.ccc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

@Configuration
public class JpaConfig {
	
	@Autowired
	private Environment enviornment;
	
	@Bean(name = "mySqlDataSource")
    @Primary
    public DataSource mySqlDataSource() 
    {
        return DataSourceBuilder.create()
        		.url(enviornment.getProperty("spring.datasource.url"))
        		.username(enviornment.getProperty("spring.datasource.username"))
        		.password(enviornment.getProperty("spring.datasource.password"))
        	.build();
    }

}

