package com.example.security.domain.client;

import com.example.security.domain.BankUsers;
import java.time.LocalDate;

public class Client extends BankUsers{

    private String passportSeries; 
    private String passportNumber; 
    private LocalDate passportIssueDate; 
    private String passportIssuedBy; 
    private String identificationNumber; 
    private String snils; 
    private ClientRole userRole;

    public String getPassportSeries() {
        return passportSeries;
    }
    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }
    public String getPassportNumber() {
        return passportNumber;
    }
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
    public LocalDate getPassportIssueDate() {
        return passportIssueDate;
    }
    public void setPassportIssueDate(LocalDate passportIssueDate) {
        this.passportIssueDate = passportIssueDate;
    }
    public String getPassportIssuedBy() {
        return passportIssuedBy;
    }
    public void setPassportIssuedBy(String passportIssuedBy) {
        this.passportIssuedBy = passportIssuedBy;
    }
    public String getIdentificationNumber() {
        return identificationNumber;
    }
    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }
    public String getSnils() {
        return snils;
    }
    public void setSnils(String snils) {
        this.snils = snils;
    }
    public ClientRole getUserRole() {
        return userRole;
    }
    public void setUserRole(ClientRole userRole) {
        this.userRole = userRole;
    }
}
