package com.assesment.backend.bankservice.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
@Entity
public class MainBorrower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mainBorrowerId;
    private String customerNumber;
    private String customerName;
    private String contactNumber;
    private String email;
    private String address;
    
    @OneToOne
    @JoinColumn(name = "facility_id")
    private FacilityDetail facility;

    public MainBorrower() {
    }

    public MainBorrower(Long mainBorrowerId, String customerNumber, String customerName, String contactNumber,
            String email, String address, FacilityDetail facility) {
        this.mainBorrowerId = mainBorrowerId;
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
        this.facility = facility;
    }

    public Long getMainBorrowerId() {
        return mainBorrowerId;
    }

    public void setMainBorrowerId(Long mainBorrowerId) {
        this.mainBorrowerId = mainBorrowerId;
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

    public FacilityDetail getFacility() {
        return facility;
    }

    public void setFacility(FacilityDetail facility) {
        this.facility = facility;
    }
}
