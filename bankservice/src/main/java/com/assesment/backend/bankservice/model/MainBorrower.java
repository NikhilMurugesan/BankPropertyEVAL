package com.assesment.backend.bankservice.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class MainBorrower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerNumber;
    private String customerName;
    private String contactNumber;
    private String email;
    private String address;

    @OneToMany(mappedBy = "mainBorrower", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Borrower> jointBorrowers = new ArrayList<>();

    // Constructors, getters, setters, and other methods

    public MainBorrower() {
    }

    public MainBorrower(Long id, String customerNumber, String customerName, String contactNumber, String email,
            String address, List<Borrower> jointBorrowers) {
        this.id = id;
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
        this.jointBorrowers = jointBorrowers;
    }

    public void addJointBorrower(Borrower jointBorrower) {
        jointBorrower.setMainBorrower(this);
        jointBorrowers.add(jointBorrower);
    }

    public void removeJointBorrower(Borrower jointBorrower) {
        jointBorrower.setMainBorrower(null);
        jointBorrowers.remove(jointBorrower);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Borrower> getJointBorrowers() {
        return jointBorrowers;
    }

    public void setJointBorrowers(List<Borrower> jointBorrowers) {
        this.jointBorrowers = jointBorrowers;
    }
}
