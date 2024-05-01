package com.assesment.backend.bankservice.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Borrower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerNumber;
    private String customerName;
    private String contactNumber;
    private String email;
    private String address;
    private boolean isMainBorrower; // Indicates whether this borrower is the Main Borrower

    @ManyToOne
    private MainBorrower mainBorrower; // Reference to the Main Borrower entity

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

    public boolean isMainBorrower() {
        return isMainBorrower;
    }

    public void setMainBorrower(boolean isMainBorrower) {
        this.isMainBorrower = isMainBorrower;
    }

    public MainBorrower getMainBorrower() {
        return mainBorrower;
    }

    public void setMainBorrower(MainBorrower mainBorrower) {
        this.mainBorrower = mainBorrower;
    }

    public Borrower(Long id, String customerNumber, String customerName, String contactNumber, String email,
            String address, boolean isMainBorrower, MainBorrower mainBorrower) {
        this.id = id;
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
        this.isMainBorrower = isMainBorrower;
        this.mainBorrower = mainBorrower;
    }

    public Borrower() {
    }

    // Constructors, getters, setters, and other methods
}
