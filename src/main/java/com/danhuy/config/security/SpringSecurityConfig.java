package com.danhuy.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.formLogin().loginPage("/login").loginProcessingUrl("/j_spring_security_check")
			.usernameParameter("username")
			.passwordParameter("password");
		
		http.formLogin().defaultSuccessUrl("/")
						.failureUrl("/login?error");
		
		http.logout().logoutSuccessUrl("/");
		
		http.exceptionHandling().accessDeniedPage("/login?accessDenied");
		
		http.authorizeRequests().antMatchers("/").permitAll()
								.antMatchers("/admin").access("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMIN_USER', 'ROLE_ADMIN_FILM')")
								.antMatchers("/admin/user/**").access("hasRole('ROLE_ADMIN_USER')")
								.antMatchers("/admin/role/**").access("hasRole('ROLE_ADMIN_USER')")
								.antMatchers("/admin/film/**").access("hasRole('ROLE_ADMIN_FILM')")
								.antMatchers("/admin/category/**").access("hasRole('ROLE_ADMIN_FILM')")
								.antMatchers("/admin/episode/**").access("hasRole('ROLE_ADMIN_FILM')")
								.antMatchers("/admin/advertise/**").access("hasRole('ROLE_ADMIN_FILM')")
								.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN') and hasRole('ROLE_ADMIN_USER') and"
																+ " hasRole('ROLE_ADMIN_FILM')")
								.antMatchers("/**/pay").access("hasRole('ROLE_USER', 'ROLE_ADMIN')");
		
		http.csrf().disable();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/static/**");
	}
}
