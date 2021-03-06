package com.cognixia.jump.ccc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.cognixia.jump.ccc.service.EnrolleeDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
				.antMatchers(HttpMethod.POST,"/registerEnrollee").permitAll()
//				.antMatchers("/enrollee/**").hasRole("ENROLLEE")
//				.anyRequest().permitAll()
//			.and()
//				.formLogin().permitAll()
//			.and()
//				.httpBasic()
			;
	}
	
///////////////////////////////////////
// BCryptBean
///////////////////////////////////////
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(16);
	}
	
///////////////////////////////////////
// UserDetailsService
///////////////////////////////////////
	
	@Bean
	public UserDetailsService userDetailsService() {
	    return new EnrolleeDetailsService();
	}
	
///////////////////////////////////////
// DAO Authentication
///////////////////////////////////////
	@Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
}
