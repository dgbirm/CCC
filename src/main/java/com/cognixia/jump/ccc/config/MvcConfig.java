package com.cognixia.jump.ccc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

///////////////////////////////////////
// Cors
///////////////////////////////////////
    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	registry.addMapping("/**")
    	.allowCredentials(true)
    	.allowedMethods("GET","PUT","POST","HEAD","DELETE","OPTIONS");    
   }
    
}

