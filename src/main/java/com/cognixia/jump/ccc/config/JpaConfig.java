package com.cognixia.jump.ccc.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class JpaConfig {
	
	@Bean(name = "mySqlDataSource")
    @Primary
    public DataSource mySqlDataSource() 
    {
        return DataSourceBuilder.create().build();
    }

}
