package com.assesment.backend.bankservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assesment.backend.bankservice.model.Borrower;

@RestController
@RequestMapping("/api/borrowers")
public class BorrowerController {
     private List<Borrower> mainBorrowerList = new ArrayList<>();
    private List<Borrower> jointBorrowerList = new ArrayList<>();

    @PostMapping("/main")
    public Borrower addMainBorrower(@RequestBody Borrower mainBorrower) {
        mainBorrowerList.add(mainBorrower);
        return mainBorrower;
    }

    @GetMapping("/main")
    public List<Borrower> getAllMainBorrowers() {
        return mainBorrowerList;
    }

    @PostMapping("/joint")
    public Borrower addJointBorrower(@RequestBody Borrower jointBorrower) {
        jointBorrowerList.add(jointBorrower);
        return jointBorrower;
    }

    @GetMapping("/joint")
    public List<Borrower> getAllJointBorrowers() {
        return jointBorrowerList;
    }

    @DeleteMapping("/joint/{index}")
    public void removeJointBorrower(@PathVariable int index) {
        if (index >= 0 && index < jointBorrowerList.size()) {
            jointBorrowerList.remove(index);
        }
    }
}