package com.assesment.backend.bankservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assesment.backend.bankservice.model.MainBorrower;

@Repository
public interface MainBorrowerRepository extends JpaRepository<MainBorrower, Long> {
}
