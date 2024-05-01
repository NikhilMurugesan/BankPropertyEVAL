package com.assesment.backend.bankservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assesment.backend.bankservice.model.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}