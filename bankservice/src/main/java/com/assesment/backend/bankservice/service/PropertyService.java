package com.assesment.backend.bankservice.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assesment.backend.bankservice.repository.PropertyValuationRepository;

import java.util.List;

@Service
public class PropertyService {

    @Autowired
    private PropertyValuationRepository propertyValuationRepository;

    public List<Object[]> findPropertyDetails(String fosReference) {
       return propertyValuationRepository.findPropertyDetailsByFOSReference(fosReference);
    }
}

