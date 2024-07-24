package com.masaischool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	@Bean
	public SecurityFilterChain anyMethodName(HttpSecurity http) throws Exception{
		//auth is an object of AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry
		Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> customizer = 
				auth -> {
					auth.requestMatchers("/hello", "/post").permitAll()
					.requestMatchers("/**").authenticated();
				};
		
		//Disable the CSRF to allow users to access POST request without making login
		http.csrf(c -> c.disable())
		.authorizeHttpRequests(customizer)
		.formLogin(Customizer.withDefaults());
		
		return http.build();
	}
	
	//Create the user dynamically (During run time)
	@Bean
	public UserDetailsService getUser() {
		UserDetails build = User.withDefaultPasswordEncoder()
		.username("abcd")
		.password("12345").build();
		return new InMemoryUserDetailsManager(build);
	}
}
