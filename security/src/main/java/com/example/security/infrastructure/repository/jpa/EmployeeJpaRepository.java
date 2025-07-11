package com.example.security.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.security.infrastructure.repository.jpa.entity.EmployeeEntity;

public interface EmployeeJpaRepository extends JpaRepository<EmployeeEntity, Long>{
    
}
