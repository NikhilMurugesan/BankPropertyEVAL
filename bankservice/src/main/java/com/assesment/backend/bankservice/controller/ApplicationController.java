package com.assesment.backend.bankservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import  com.assesment.backend.bankservice.model.Application;
import com.assesment.backend.bankservice.service.ApplicationService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/applications")
public class ApplicationController {
    private final ApplicationService applicationService;

    // Constructor

    public ApplicationController() {
        this.applicationService = new ApplicationService();
    }

    @PostMapping("/createapplication")
    public ResponseEntity<Application> createApplication(@RequestBody Application application) {
        Application createdApplication = applicationService.createApplication(application);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdApplication);
    }

    @GetMapping("/{referenceNumber}")
    public ResponseEntity<Application> getApplicationByReferenceNumber(@PathVariable String referenceNumber) {
        Application application = applicationService.getApplicationByReferenceNumber(referenceNumber);
        return ResponseEntity.ok(application);
    }

    // Other endpoints
}