package com.assesment.backend.bankservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assesment.backend.bankservice.model.PurposeOfValuation;
import com.assesment.backend.bankservice.service.PurposeOfValuationService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PurposeOfValuationController {

    @Autowired
    private PurposeOfValuationService purposeOfValuationService;

    @GetMapping("/purposes-of-valuation")
    public List<PurposeOfValuation> getAllPurposes() {
        return purposeOfValuationService.getAllPurposes();
    }
}

