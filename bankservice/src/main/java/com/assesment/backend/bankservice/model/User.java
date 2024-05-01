package com.assesment.backend.bankservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String initiatorName; // Non-editable field
    private String businessUnit; // Non-editable field
    private String contactNumber;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getInitiatorName() {
        return initiatorName;
    }
    public void setInitiatorName(String initiatorName) {
        this.initiatorName = initiatorName;
    }
    public String getBusinessUnit() {
        return businessUnit;
    }
    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public User(Long id, String username, String password, String initiatorName, String businessUnit,
            String contactNumber) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.initiatorName = initiatorName;
        this.businessUnit = businessUnit;
        this.contactNumber = contactNumber;
    }
    public User() {
    }

    // Constructors, getters, setters, and other methods
}