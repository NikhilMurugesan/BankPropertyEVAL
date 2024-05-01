package com.assesment.backend.bankservice.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String referenceNumber;
    // Other fields
    public Long getId() {
        return id;
    }
    public Application(Long id, String referenceNumber) {
        this.id = id;
        this.referenceNumber = referenceNumber;
    }
    public Application() {
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getReferenceNumber() {
        return referenceNumber;
    }
    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }
    
    // Getters and setters
}
