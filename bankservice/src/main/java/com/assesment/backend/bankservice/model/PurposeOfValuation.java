package com.assesment.backend.bankservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "purposeofvaluation")
public class PurposeOfValuation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column
    private Long id;
    
    @Column
    private int code;
    
    @Column
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PurposeOfValuation(Long id, int code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public PurposeOfValuation() {
    }

    // Getters and setters
}