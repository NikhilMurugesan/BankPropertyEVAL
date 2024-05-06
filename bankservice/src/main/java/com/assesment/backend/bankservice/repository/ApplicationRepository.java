package com.assesment.backend.bankservice.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assesment.backend.bankservice.model.Application;
@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    
     Application findByReferenceNumber(String referenceNumber);
     
     @Query(value = "SELECT DISTINCT a.reference_number, a.facility_id, (SELECT f.amount FROM facility_detail f WHERE f.facility_id = a.facility_id LIMIT 1) AS amount, (SELECT f.type FROM facility_detail f WHERE f.facility_id = a.facility_id LIMIT 1) AS type_of_facility, (SELECT f.category FROM facility_detail f WHERE f.facility_id = a.facility_id LIMIT 1) AS category, (SELECT CASE WHEN EXISTS (SELECT 1 FROM main_borrower m WHERE m.facility_id = a.facility_id) THEN 1 ELSE 0 END) AS has_main_borrower, mb.customer_name FROM application a LEFT JOIN main_borrower mb ON mb.facility_id = a.facility_id LIMIT 0, 1000", nativeQuery = true)
     List<Object> findAllByReferenceNumber();


}

