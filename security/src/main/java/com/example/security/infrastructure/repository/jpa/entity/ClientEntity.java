package com.example.security.infrastructure.repository.jpa.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

import com.example.security.domain.client.ClientRole;

@Entity
@Table(name = "client")
public class ClientEntity extends BankUsersEntity {

    @Column(name = "passport_series")
    private String passportSeries;

    @Column(name = "passport_number")
    private String passportNumber;

    @Column(name = "passport_issue_date")
    private LocalDate passportIssueDate;

    @Column(name = "passport_issued_by")
    private String passportIssuedBy;

    @Column(name = "identification_number")
    private String identificationNumber;

    @Column(name = "snils")
    private String snils;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private ClientRole userRole;

}
