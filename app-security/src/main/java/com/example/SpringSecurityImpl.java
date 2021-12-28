package com.example;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class SpringSecurityImpl extends WebSecurityConfigurerAdapter
{
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
				
		auth.inMemoryAuthentication()
			.withUser("test").password("{noop}test123").roles("USER")
			.and()
			.withUser("read").password("{noop}read123").roles("READ")
			.and()
			.withUser("admin").password("{noop}admin123").roles("ADMIN","USER")
			.and()
			.withUser("apiuser").password("{noop}apiuser123").roles("API");
	}

	
	  protected void configure(HttpSecurity http) throws Exception {
		  http.csrf().disable();
		  
		  http.authorizeRequests()
		  	.antMatchers("/admin/*").hasAnyRole("ADMIN")
		    .antMatchers("/user/*").hasRole("USER") 
		    .antMatchers("/").permitAll() 
		    .and()
		    .formLogin();
		  
			
		  http.authorizeRequests()
		  	.antMatchers("/api/*").hasAnyRole("API") 
		  	.and()
			.httpBasic();
			 
	  }
	 
	
}
