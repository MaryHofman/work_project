package com.example.security.infrastructure.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.example.security.application.CustomUserDetailsService;
import com.example.security.application.JwtService;
import com.example.security.infrastructure.filters.JWTAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    
    @Autowired
    private JwtService jwtService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.GET, "/api/security/user/information").authenticated() 
                .anyRequest().permitAll()  
            )
            .csrf().disable()
            .formLogin(form -> form.disable()) 
            .httpBasic().disable()  
            .addFilterBefore(jwtAuthenticationFilter(), BasicAuthenticationFilter.class) 
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);  

        return http.build();
    }

    @Bean
    public JWTAuthenticationFilter jwtAuthenticationFilter() {
        return new JWTAuthenticationFilter(jwtService, customUserDetailsService);
    }
}
