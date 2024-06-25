package com.assesment.backend.bankservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assesment.backend.bankservice.model.FacilityDetail;
import com.assesment.backend.bankservice.service.FacilityDetailService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/facilities")
public class FacilityDetailController {
    private FacilityDetailService facilityDetailService;

    @Autowired
    public FacilityDetailController(FacilityDetailService facilityDetailService) {
        this.facilityDetailService = facilityDetailService;
    }

    @GetMapping
    public ResponseEntity<List<FacilityDetail>> getAllFacilities() {
        List<FacilityDetail> facilities = facilityDetailService.getAllFacilities();
        return new ResponseEntity<>(facilities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacilityDetail> getFacilityById(@PathVariable Long id) {
        FacilityDetail facility = facilityDetailService.getFacilityById(id);
        if (facility != null) {
            return new ResponseEntity<>(facility, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addfacility")
    public ResponseEntity<FacilityDetail> addFacility(@RequestBody FacilityDetail facilityDetail) {
        FacilityDetail newFacility = facilityDetailService.addFacility(facilityDetail);
        return new ResponseEntity<>(newFacility, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacilityDetail> updateFacility(@PathVariable Long id, @RequestBody FacilityDetail facilityDetail) {
        FacilityDetail updatedFacility = facilityDetailService.updateFacility(id, facilityDetail);
        if (updatedFacility != null) {
            return new ResponseEntity<>(updatedFacility, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFacility(@PathVariable Long id) {
        facilityDetailService.deleteFacility(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
