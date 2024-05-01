package com.assesment.backend.bankservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assesment.backend.bankservice.model.TypeOfFacility;
import com.assesment.backend.bankservice.service.TypeOfFacilityService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TypeOfFacilityController {

    @Autowired
    private TypeOfFacilityService typeOfFacilityService;

    @GetMapping("/type-of-facility")
    public List<TypeOfFacility> getAllTypes() {
        return typeOfFacilityService.getAllTypes();
    }
}
