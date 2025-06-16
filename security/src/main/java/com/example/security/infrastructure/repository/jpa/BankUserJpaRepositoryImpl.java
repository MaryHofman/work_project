package com.example.security.infrastructure.repository.jpa;

import org.springframework.stereotype.Repository;

import com.example.security.infrastructure.repository.jpa.entity.BankUsersEntity;

@Repository
public class BankUserJpaRepositoryImpl {

    public BankUsersEntity findByLogin(String email) {
        return null;
    }
    
}
