package com.assesment.backend.bankservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assesment.backend.bankservice.model.Currency;
import com.assesment.backend.bankservice.service.CurrencyService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/currencies")
    public List<Currency> getAllCurrencies() {
        return currencyService.getAllCurrencies();
    }
}
