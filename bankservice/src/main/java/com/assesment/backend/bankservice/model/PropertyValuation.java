package com.assesment.backend.bankservice.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PropertyValuation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @SuppressWarnings("unused")
    private String fosReference; // Format: YYYY/MM/XXXX
    @SuppressWarnings("unused")
    private String typeOfEvaluation; // New or Existing

    // Constructors, getters, setters, and other methods

    public PropertyValuation() {
        LocalDate currentDate = LocalDate.now();
        String year = String.valueOf(currentDate.getYear());
        String month = String.format("%02d", currentDate.getMonthValue());
        // You may need to retrieve the sequential application number from a database or generate it programmatically
        // For demonstration purposes, I'll assume it's retrieved from a database
        int sequentialApplicationNumber = getNextSequentialApplicationNumber(currentDate);
        this.fosReference = year + "/" + month + "/" + String.format("%04d", sequentialApplicationNumber);
    }

    private int getNextSequentialApplicationNumber(LocalDate currentDate) {
        // Logic to retrieve the next sequential application number based on the current date
        // This could involve querying the database to get the last application number and incrementing it
        // For demonstration, let's assume it's retrieved from a database or generated programmatically
        return 1; // Dummy value, replace with actual logic
    }
}