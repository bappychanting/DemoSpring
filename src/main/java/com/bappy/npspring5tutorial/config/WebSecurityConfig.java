package com.bappy.npspring5tutorial.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Resource
	public UserDetailsService userService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/",
						"/home",
						"/signup",
						"/forgot-password",
						"/reset-password/*",
						"/public/**").permitAll().anyRequest().authenticated();
		http.formLogin().loginPage("/login").permitAll().and().logout().permitAll();
	}
	
	@Autowired
	@Override
	protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception{
		authManagerBuilder.userDetailsService(userService);
	}
	
	
}
