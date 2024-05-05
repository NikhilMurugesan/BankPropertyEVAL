package com.assesment.backend.bankservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import  com.assesment.backend.bankservice.model.Application;
import com.assesment.backend.bankservice.model.FacilityDetail;
import com.assesment.backend.bankservice.repository.ApplicationRepository;
import com.assesment.backend.bankservice.service.ApplicationService;
import com.assesment.backend.bankservice.service.FacilityDetailService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/applications")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    private ApplicationRepository applicationRepository;
    // Constructor
    @Autowired
    private FacilityDetailService facilityDetailService;
    private FacilityDetail facilityDetail;

    public ApplicationController() {
        this.applicationService = new ApplicationService();
    }

    @PostMapping("/{facility_id}")
    public ResponseEntity<Application> createApplication(@PathVariable("facility_id") Long facilityID) {
        Application application = new Application();
        facilityDetail = facilityDetailService.getFacilityById(facilityID);
        application.setFacility(facilityDetail);
        Application createdApplication = applicationService.createApplication(application);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdApplication);
    }

    @GetMapping("/{referenceNumber}")
    public ResponseEntity<Application> getApplicationByReferenceNumber(@PathVariable String referenceNumber) {
        Application application = applicationService.getApplicationByReferenceNumber(referenceNumber);
        return ResponseEntity.ok(application);
    }
   @GetMapping("/search")
    public List<Application> searchApplications(@RequestParam(required = false) String reference,
                                                @RequestParam(required = false) LocalDate fromDate,
                                                @RequestParam(required = false) LocalDate toDate) {
        if (reference != null) {
            // Search by reference number
            return applicationRepository.findAllByReferenceNumber(reference);
        } else if (fromDate != null && toDate != null) {
            // Search by date range
            return null;
           // return applicationRepository.findBySubmissionDateBetween(fromDate.atStartOfDay(), toDate.atTime(LocalTime.MAX));
        } else {
            // Handle other search criteria
            // You can implement other search criteria as needed
            return Collections.emptyList();
        }
    }
    // Other endpoints
    
}