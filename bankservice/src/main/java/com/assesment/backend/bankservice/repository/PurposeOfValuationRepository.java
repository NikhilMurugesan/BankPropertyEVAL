package com.assesment.backend.bankservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.assesment.backend.bankservice.model.PurposeOfValuation;

public interface PurposeOfValuationRepository extends JpaRepository<PurposeOfValuation, Long> {
}