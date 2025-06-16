package com.example.security.domain.employee;

import com.example.security.domain.BankUsers;
import java.time.LocalDate;
import java.util.List;

public class Employee extends BankUsers{


    private EmployeeRole userRole;
    private String employeeId;
    private String position;
    private String department;
    private String branch;
    
    private List<String> permissions;
    private String accessLevel;
    
    private LocalDate employmentDate;
    private LocalDate terminationDate;
    private String employmentContractNumber;
    
    private String workEmail;
    private String workPhone;
    private String internalExtension;


    public EmployeeRole getUserRole() {
        return userRole;
    }
    public void setUserRole(EmployeeRole userRole) {
        this.userRole = userRole;
    }
    public String getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }
    public List<String> getPermissions() {
        return permissions;
    }
    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
    public String getAccessLevel() {
        return accessLevel;
    }
    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }
    public LocalDate getEmploymentDate() {
        return employmentDate;
    }
    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }
    public LocalDate getTerminationDate() {
        return terminationDate;
    }
    public void setTerminationDate(LocalDate terminationDate) {
        this.terminationDate = terminationDate;
    }
    public String getEmploymentContractNumber() {
        return employmentContractNumber;
    }
    public void setEmploymentContractNumber(String employmentContractNumber) {
        this.employmentContractNumber = employmentContractNumber;
    }
    public String getWorkEmail() {
        return workEmail;
    }
    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }
    public String getWorkPhone() {
        return workPhone;
    }
    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }
    public String getInternalExtension() {
        return internalExtension;
    }
    public void setInternalExtension(String internalExtension) {
        this.internalExtension = internalExtension;
    }   

    }

    
    

