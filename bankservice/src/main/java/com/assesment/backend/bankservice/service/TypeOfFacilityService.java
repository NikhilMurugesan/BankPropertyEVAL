package com.assesment.backend.bankservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assesment.backend.bankservice.model.TypeOfFacility;
import com.assesment.backend.bankservice.repository.TypeOfFacilityRepository;

import java.util.List;

@Service
public class TypeOfFacilityService {

    @Autowired
    private TypeOfFacilityRepository repository;

    public List<TypeOfFacility> getAllTypes() {
        return repository.findAll();
    }
}
