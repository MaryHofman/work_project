package com.example.security.infrastructure.filters;

import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;


import com.example.security.application.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.example.security.application.CustomUserDetailsService;


@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private  JwtService jwtService;

    @Autowired
    private CustomUserDetailsService userDetailsService;


   

    public JWTAuthenticationFilter(JwtService jwtService2, CustomUserDetailsService customUserDetailsService) {
                this.jwtService = jwtService2;
                this.userDetailsService = customUserDetailsService;
    }




    @Override
    protected void doFilterInternal(HttpServletRequest request, 
                                    HttpServletResponse response, 
                                    FilterChain filterChain) 
                                    throws ServletException, IOException {

        String authorizationHeader = request.getHeader("Authorization");

        if (StringUtils.hasText(authorizationHeader)) {
            String token = authorizationHeader;

            if (jwtService.validateToken(token, jwtService.getSecurityAccess())) {
                String username = jwtService.extractAllClaims(token, jwtService.getSecurityAccess()).get("email", String.class);
                System.out.println("Email "+username);
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

       
        filterChain.doFilter(request, response);
    }
}
