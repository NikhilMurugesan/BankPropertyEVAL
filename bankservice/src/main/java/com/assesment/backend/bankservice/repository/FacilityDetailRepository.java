package com.assesment.backend.bankservice.repository;

import com.assesment.backend.bankservice.model.FacilityDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityDetailRepository extends JpaRepository<FacilityDetail, Long> {
    // You can add custom query methods here if needed
}
