package com.training.secure.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	//add @Autowire dependency
	@Autowired
	private DataSource securityDataSource;
	
	//add user details for in memory authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//set up jdbc authentication
		auth.jdbcAuthentication().dataSource(this.securityDataSource);
			
	}
	
	//configure the web path, protected resource,custom login,logout
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
	http.authorizeRequests() //used to specify what request/url to authorize			
			.antMatchers("/subject/**").hasRole("PRINCIPAL")
			.antMatchers("/book/**").hasRole("LIBIARIAN")
			.and()//allows to add more security config/rules
		.formLogin() //used to specify what login form to use
			.loginPage("/mylogin") //uri to access custom login page
			.loginProcessingUrl("/checkUser")//url/resource that check username/password
			.permitAll() //allow everyone to see login page
	.and()
		.logout().permitAll() //provide an inbuilt support for default logout url (/logout)
	.and()
		.exceptionHandling()
			.accessDeniedPage("/accessdenied");//url will be called in Access Denied
	}
}
