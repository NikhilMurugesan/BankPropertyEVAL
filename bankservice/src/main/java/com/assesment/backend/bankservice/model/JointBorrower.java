package com.assesment.backend.bankservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class JointBorrower {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jointBorrowerId;
    
    private String customerNumber;
    
    private String customerName;
    
    private String contactNumber;
    
    private String email;
    
    private String address;
    
    @OneToOne
    @JoinColumn(name = "main_borrower_id")
    private MainBorrower mainBorrower;

    public JointBorrower(Long jointBorrowerId, String customerNumber, String customerName, String contactNumber,
            String email, String address, MainBorrower mainBorrower) {
        this.jointBorrowerId = jointBorrowerId;
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
        this.mainBorrower = mainBorrower;
    }

    public JointBorrower() {
    }

    public Long getJointBorrowerId() {
        return jointBorrowerId;
    }

    public void setJointBorrowerId(Long jointBorrowerId) {
        this.jointBorrowerId = jointBorrowerId;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public MainBorrower getMainBorrower() {
        return mainBorrower;
    }

    public void setMainBorrower(MainBorrower mainBorrower) {
        this.mainBorrower = mainBorrower;
    }

    // Getters and setters
}
