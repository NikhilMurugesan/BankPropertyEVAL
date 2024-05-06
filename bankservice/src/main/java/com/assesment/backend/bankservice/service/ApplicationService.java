package com.assesment.backend.bankservice.service;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assesment.backend.bankservice.model.Application;
import com.assesment.backend.bankservice.repository.ApplicationRepository;

@Service
public class ApplicationService {
    
    @Autowired
    private  ApplicationRepository applicationRepository;
    private  AtomicLong sequence = new AtomicLong(1);

    // Constructor

    public Application createApplication(Application application) {
        // Generate reference number
        application.setReferenceNumber(generateReferenceNumber());
        // Save application
        return applicationRepository.save(application);
    }

    public ApplicationService() {
    }

    private String generateReferenceNumber() {
         LocalDate currentDate = LocalDate.now();
        String year = String.valueOf(currentDate.getYear());
        String month = String.format("%02d", currentDate.getMonthValue());
        String day = String.format("%02d", currentDate.getDayOfMonth());
        String sequenceNumber = String.format("%04d", sequence.getAndIncrement());
        return "PV" + year + month + day + sequenceNumber;
    }
    
    public Application getApplicationByReferenceNumber(String referenceNumber) {
        return applicationRepository.findByReferenceNumber(referenceNumber);
    }

    public Object getAllApplication(){
        return applicationRepository.findAllByReferenceNumber();
    }
}

