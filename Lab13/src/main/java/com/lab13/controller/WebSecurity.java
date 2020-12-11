package com.lab13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter {

		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("userpass")).roles("USER")
			.and()
			.withUser("admin").password(passwordEncoder().encode("adminpass")).roles("ADMIN");
		}
		
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("api/courses").hasAnyRole("ADMIN", "USER").and().httpBasic().and().csrf().disable();
		}
		
		@Bean
		public static PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
}
