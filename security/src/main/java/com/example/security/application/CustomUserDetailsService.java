package com.example.security.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.security.infrastructure.repository.jpa.BankUserJpaRepositoryImpl;
import com.example.security.infrastructure.repository.jpa.entity.BankUsersEntity;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private  BankUserJpaRepositoryImpl userRepository; 

    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        BankUsersEntity userEntity = userRepository.findByLogin(email);

        return org.springframework.security.core.userdetails.User.builder()
                .username(userEntity.getLogin())
                .password(userEntity.getPassword())
                .authorities("ROLE_USER")
                .build();
    }
}
