package com.assesment.backend.bankservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assesment.backend.bankservice.model.PurposeOfValuation;
import com.assesment.backend.bankservice.repository.PurposeOfValuationRepository;

import java.util.List;

@Service
public class PurposeOfValuationService {

    @Autowired
    private PurposeOfValuationRepository repository;

    public List<PurposeOfValuation> getAllPurposes() {
        return repository.findAll();
    }
}

