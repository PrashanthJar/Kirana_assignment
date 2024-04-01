package com.KiranaStore.KiranaStore.controller;

import com.KiranaStore.KiranaStore.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

    private final CurrencyExchangeService currencyExchangeService;

    @Autowired
    public CurrencyExchangeController(CurrencyExchangeService currencyExchangeService) {
        this.currencyExchangeService = currencyExchangeService;
    }

    @GetMapping("/convert")
    public ResponseEntity<Double> convertCurrency(
            @RequestParam String fromCurrency,
            @RequestParam String toCurrency,
            @RequestParam double amount) {
        double convertedAmount = currencyExchangeService.convertCurrency(amount, fromCurrency, toCurrency);
        return new ResponseEntity<>(convertedAmount, HttpStatus.OK);
    }

    @GetMapping("/{sourceCurrency}/{targetCurrency}")
    public ResponseEntity<Double> getExchangeRate(
            @PathVariable String sourceCurrency,
            @PathVariable String targetCurrency) {
        double exchangeRate = currencyExchangeService.getExchangeRate(sourceCurrency, targetCurrency);
        return new ResponseEntity<>(exchangeRate, HttpStatus.OK);
    }



}
