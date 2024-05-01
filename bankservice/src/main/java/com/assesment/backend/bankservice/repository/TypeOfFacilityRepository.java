package com.assesment.backend.bankservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.assesment.backend.bankservice.model.TypeOfFacility;

public interface TypeOfFacilityRepository extends JpaRepository<TypeOfFacility, Long> {
}