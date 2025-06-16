package com.example.security.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.security.infrastructure.repository.jpa.entity.ClientEntity;

public interface ClientJpaRepository extends JpaRepository<ClientEntity, Long>{
    
}
