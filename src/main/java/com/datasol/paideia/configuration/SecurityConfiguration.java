package com.datasol.paideia.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
@Configuration
@EnableWebMvcSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.csrf().disable().authorizeRequests().anyRequest().authenticated();
		http.csrf().disable().authorizeRequests().antMatchers("/crazy/**").access("hasRole('ROLE_ADMIN')");
	}
	
	

}
