package com.boot.board.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.boot.board.user.UserSecurityService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity//모든 url을 스프링의 권한 아래에 둔다 
@EnableGlobalMethodSecurity(prePostEnabled = true)//preauthorize를 사용하는걸 알려주는 어노테이션
public class SecurityConfig {
	
	private final UserSecurityService userSecurityService;
	
	
	//메모리에 메소드를 올려놔야 밑에 로그인 허락 메소드가 실행된다
	@Bean//메소드를 객체화 해서 메모리에 올린다
	public SecurityFilterChain filterChain(HttpSecurity http) 
			throws Exception{
		
		//모든 인증되지 않은 요청을 허락
		http
		.authorizeRequests().antMatchers("/**").permitAll()
		.and()
		.csrf().ignoringAntMatchers("/h2-console/**")//특정 사이트 풀어주기
		.and()
		.headers().addHeaderWriter(new XFrameOptionsHeaderWriter(
				XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
		.and()
		.formLogin().loginPage("/user/login").defaultSuccessUrl("/")
		.and()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
		.logoutSuccessUrl("/").invalidateHttpSession(true)
		;
		
		return http.build();
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//AuthenticationManager는 스프링 security의 인증을 담당하는 클래스
	@Bean
	public AuthenticationManager authenticationManager(
			AuthenticationConfiguration authenticationConfiguration) 
		throws Exception{
		
		return authenticationConfiguration
				.getAuthenticationManager();
	}
	
}
