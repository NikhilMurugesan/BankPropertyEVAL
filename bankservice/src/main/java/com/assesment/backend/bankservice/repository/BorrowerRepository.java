package com.assesment.backend.bankservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assesment.backend.bankservice.model.Borrower;
@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {
    // Additional methods if needed
}