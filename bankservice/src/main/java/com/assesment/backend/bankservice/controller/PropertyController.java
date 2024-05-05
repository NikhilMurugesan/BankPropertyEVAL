package com.assesment.backend.bankservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assesment.backend.bankservice.repository.PropertyValuationRepository;

import java.util.List;

@RestController
@RequestMapping("api/property")
public class PropertyController {

    private final PropertyValuationRepository propertyValuationRepository;

    @Autowired
    public PropertyController(PropertyValuationRepository propertyValuationRepository) {
        this.propertyValuationRepository = propertyValuationRepository;
    }

    @GetMapping("/details/{fosReference}")
    public List<Object[]> getPropertyDetailsByFOSReference(@PathVariable String fosReference) {
        return propertyValuationRepository.findPropertyDetailsByFOSReference(fosReference);
    }
}
