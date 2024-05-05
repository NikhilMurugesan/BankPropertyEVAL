package com.assesment.backend.bankservice.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assesment.backend.bankservice.model.Application;
@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    
     Application findByReferenceNumber(String referenceNumber);
     List< Application> findAllByReferenceNumber(String referenceNumber);
}

