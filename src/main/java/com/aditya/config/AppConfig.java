package com.aditya.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebMvc
public class AppConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
	   http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
	   .authorizeHttpRequests(Authorize-> Authorize.requestMatchers("/api/**").authenticated().anyRequest().permitAll())
	   .addFilterBefore(new JwtValidator(), BasicAuthenticationFilter.class)
	   .csrf().disable()
	   .cors().configurationSource(new CorsConfigurationSource() {
		
		@Override
		public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
			// TODO Auto-generated method stub
			CorsConfiguration cfg = new CorsConfiguration();
			cfg.setAllowedOrigins(Arrays.asList(
					"http://localhost:3000/",
					"https://ecommercebymanish3.vercel.app/"));
			cfg.setAllowedMethods(Collections.singletonList("*"));
			cfg.setAllowCredentials(true);
			cfg.setAllowedHeaders(Collections.singletonList("*"));
			cfg.setExposedHeaders(Arrays.asList("Authorization"));
			cfg.setMaxAge(3600L);
			
	   
			return cfg;
		}
	})
	   .and().httpBasic().and().formLogin();
		return http.build();
	}
	
	//create hashed password
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	@Bean
	SecurityFilterChain web(HttpSecurity http) throws Exception {
	    http
	        .authorizeHttpRequests((authorize) -> authorize
	            .requestMatchers("/v3/api-docs").permitAll()
	        );
	        // ...

	    return http.build();
	} 
	
	

}
