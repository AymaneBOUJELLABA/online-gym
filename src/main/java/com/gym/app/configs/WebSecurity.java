package com.gym.app.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.gym.app.services.UserService;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter 
{
	
	@Autowired
	UserService userService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable().authorizeRequests().antMatchers("/signup","/login").permitAll()
        .anyRequest().authenticated();
	}
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		
		return super.authenticationManagerBean();
		
	}
	
	
	@Autowired
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() 
	{
        return new BCryptPasswordEncoder();
    }
    

    @Autowired
    CustomizeAuthenticationSuccessHandler customizeAuthenticationSuccessHandler;

    @Bean
    public UserDetailsService mongoUserDetails() {
        return new UserService();
    }

    
	
	
	
}
