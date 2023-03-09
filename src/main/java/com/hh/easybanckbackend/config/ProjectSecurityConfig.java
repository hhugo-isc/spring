package com.hh.easybanckbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

	@Bean
	SecurityFilterChain defaSecurityFilterChain(HttpSecurity http) throws Exception {
		/**
		 * Bellow is the custom security configuration
		 */
		http.csrf().disable().authorizeHttpRequests().antMatchers("myAccount", "/myBallance", "/myLoans", "/myCards")
				.authenticated().antMatchers("/contact", "/notices", "/register").permitAll().and().formLogin().and()
				.httpBasic();
		return http.build();

	}

	/**
	 * NoOpPasswordEncoder is not recommended for production usage Use only for
	 * non-prod
	 * 
	 * @return PasswordEncoder
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
