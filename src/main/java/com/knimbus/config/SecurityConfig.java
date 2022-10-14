//package com.knimbus.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
// //to create the spring security filter chain -> () ->()-> ()-> resource
//
//	@Override
//	protected void configure(final HttpSecurity http) throws Exception {
//		// @formatter:off
//		http.cors();
//		http.csrf().disable().authorizeRequests().antMatchers("/**").fullyAuthenticated().and().httpBasic();
//	}
//	
//	// authentication
//		@Override
//		public void configure(AuthenticationManagerBuilder auth) throws Exception {
//	auth.inMemoryAuthentication().withUser("annu@gmaill.cpm")
//	.password("Test@123");
//
//}
//}
