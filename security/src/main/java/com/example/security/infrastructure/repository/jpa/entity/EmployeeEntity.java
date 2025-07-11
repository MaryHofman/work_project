package com.example.security.infrastructure.repository.jpa.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

import com.example.security.domain.employee.EmployeeRole;

@Entity
@Table(name = "employee")
@PrimaryKeyJoinColumn(name = "id") 
public class EmployeeEntity extends BankUsersEntity {

    @Column(name = "employee_id", nullable = false, unique = true)
    private String employeeId;

    @Column(name = "position")
    private String position;

    @Column(name = "department")
    private String department;

    @Column(name = "branch")
    private String branch;

    @ElementCollection
    @CollectionTable(name = "employee_permissions", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "permission")
    private List<String> permissions;

    @Column(name = "access_level")
    private String accessLevel;

    @Column(name = "employment_date")
    private LocalDate employmentDate;

    @Column(name = "termination_date")
    private LocalDate terminationDate;

    @Column(name = "contract_number")
    private String employmentContractNumber;

    @Column(name = "work_email")
    private String workEmail;

    @Column(name = "work_phone")
    private String workPhone;

    @Column(name = "internal_extension")
    private String internalExtension;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private EmployeeRole userRole;

}