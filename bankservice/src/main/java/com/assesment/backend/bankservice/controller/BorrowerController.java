package com.assesment.backend.bankservice.controller;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assesment.backend.bankservice.model.FacilityDetail;
import com.assesment.backend.bankservice.model.JointBorrower;
import com.assesment.backend.bankservice.model.MainBorrower;
import com.assesment.backend.bankservice.service.BorrowerService;
import com.assesment.backend.bankservice.service.FacilityDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/borrowers")
public class BorrowerController {

    @Autowired
    private BorrowerService borrowerService;

    @Autowired
    private FacilityDetailService facilityDetailService;
    private FacilityDetail facilityDetail;
    public MainBorrower mainborrower;
    @PostMapping("/main/{facilityid}")
    public ResponseEntity<MainBorrower> addMainBorrower(@RequestBody MainBorrower mainBorrower,@PathVariable("facilityid") Long facilityID) {
        facilityDetail = facilityDetailService.getFacilityById(facilityID);
        mainBorrower.setFacility(facilityDetail);
        MainBorrower savedMainBorrower = borrowerService.saveMainBorrower(mainBorrower);
        mainborrower = savedMainBorrower;
        
        return new ResponseEntity<>(savedMainBorrower, HttpStatus.CREATED);
    }

    @GetMapping("/main")
    public ResponseEntity<List<MainBorrower>> getAllMainBorrowers() {
        List<MainBorrower> mainBorrowers = borrowerService.findAllMainBorrowers();
        return new ResponseEntity<>(mainBorrowers, HttpStatus.OK);
    }

    @GetMapping("/main/{id}")
    public ResponseEntity<MainBorrower> getMainBorrowerById(@PathVariable("id") Long mainBorrowerId) {
        MainBorrower mainBorrower = borrowerService.findMainBorrowerById(mainBorrowerId);
        return new ResponseEntity<>(mainBorrower, HttpStatus.OK);
    }

    @DeleteMapping("/main/{id}")
    public ResponseEntity<Void> deleteMainBorrower(@PathVariable("id") Long mainBorrowerId) {
        borrowerService.deleteMainBorrower(mainBorrowerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/joint/{id}")
    public ResponseEntity<JointBorrower> addJointBorrower(@RequestBody JointBorrower jointBorrower,@PathVariable("id") Long id) {
        mainborrower = borrowerService.findMainBorrowerById(id);
        jointBorrower.setMainBorrower(mainborrower);
        JointBorrower savedJointBorrower = borrowerService.saveJointBorrower(jointBorrower);
        
        return new ResponseEntity<>(savedJointBorrower, HttpStatus.CREATED);
    }

    @GetMapping("/joint")
    public ResponseEntity<List<JointBorrower>> getAllJointBorrowers() {
        List<JointBorrower> jointBorrowers = borrowerService.findAllJointBorrowers();
        return new ResponseEntity<>(jointBorrowers, HttpStatus.OK);
    }

    @GetMapping("/joint/{id}")
    public ResponseEntity<JointBorrower> getJointBorrowerById(@PathVariable("id") Long jointBorrowerId) {
        Optional<JointBorrower> jointBorrower = borrowerService.findJointBorrowerById(jointBorrowerId);
        return jointBorrower.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/joint/{id}")
    public ResponseEntity<Void> deleteJointBorrower(@PathVariable("id") Long jointBorrowerId) {
        borrowerService.deleteJointBorrower(jointBorrowerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
