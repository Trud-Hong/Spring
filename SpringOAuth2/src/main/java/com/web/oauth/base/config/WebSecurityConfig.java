package com.web.oauth.base.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.web.oauth.base.model.BaseAuthRole;
import com.web.oauth.base.model.BaseAuthUser;
import com.web.oauth.base.service.BaseCustomOAuth2UserService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
	
	@Autowired
	private final BaseCustomOAuth2UserService baseCustomOAuth2UserService;
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception{
		
		http
		.csrf().disable().headers().frameOptions().disable()
		.and()
		.authorizeHttpRequests()
		.antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**").permitAll()
		.antMatchers("/api/v1/**").hasRole(BaseAuthRole.USER.name())
		.anyRequest().authenticated()
		.and()
		.logout().logoutSuccessUrl("/")
		.deleteCookies("JESSIONID").invalidateHttpSession(true)
		.and()
		.oauth2Login().defaultSuccessUrl("/").userInfoEndpoint()
		.userService(baseCustomOAuth2UserService);
		
		return http.build();
		
	}
	
	

}
