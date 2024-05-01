package com.assesment.backend.bankservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assesment.backend.bankservice.model.Currency;
import com.assesment.backend.bankservice.repository.CurrencyRepository;

import java.util.List;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository repository;

    public List<Currency> getAllCurrencies() {
        return repository.findAll();
    }
}

