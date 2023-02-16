package com.hh.easybanckbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
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

//	@Bean
//	public InMemoryUserDetailsManager userDetailService() {
//		/**
//		 * Approach 1: we use withDefaultPasswordEncoder() method while creating the
//		 * user details
//		 */
//
////		UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("password")
////				.authorities("admin").build();
////		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").authorities("read")
////				.build();
//
//		/**
//		 * Approach 2: we use NoOpPasswordRncoder BEAN while creating the user details
//		 */
//		UserDetails admin = User.withUsername("admin").password("password").authorities("admin").build();
//		UserDetails user = User.withUsername("user").password("password").authorities("read").build();
//
//		return new InMemoryUserDetailsManager(admin, user);
//	}

//	@Bean
//	public UserDetailsService userDetailService(DataSource dataSource) {
//		return new JdbcUserDetailsManager(dataSource);
//	}

	/**
	 * NoOpPasswordEncoder is not recommended for production usage Use only for
	 * non-prod
	 * 
	 * @return PasswordEncoder
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
