package com.assesment.backend.bankservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FacilityDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type; // Revolving or Non-revolving
    private String category; // 25000 - Apartment, 25010 – PBWM Housing
    private String purpose; // Reparation, Inheritance, Construction
    private int termMonths;
    private String currency; // MUR, EUR, USD, GBP, ZAR
    private double amount;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getPurpose() {
        return purpose;
    }
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
    public int getTermMonths() {
        return termMonths;
    }
    public void setTermMonths(int termMonths) {
        this.termMonths = termMonths;
    }
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public FacilityDetail(Long id, String type, String category, String purpose, int termMonths, String currency,
            double amount) {
        this.id = id;
        this.type = type;
        this.category = category;
        this.purpose = purpose;
        this.termMonths = termMonths;
        this.currency = currency;
        this.amount = amount;
    }
    public FacilityDetail() {
    }

    // Constructors, getters, setters, and other methods
}