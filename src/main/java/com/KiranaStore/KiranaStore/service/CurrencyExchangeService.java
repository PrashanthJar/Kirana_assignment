package com.KiranaStore.KiranaStore.service;

import com.KiranaStore.KiranaStore.dto.ExchangeRateResponse;
import com.KiranaStore.KiranaStore.model.CurrencyExchangeRate;
import com.KiranaStore.KiranaStore.repository.CurrencyExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Service
public class CurrencyExchangeService {
    @Autowired
    private CurrencyExchangeRateRepository currencyExchangeRateRepository;

    public void updateExchangeRates() {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://fxratesapi.com/latest";
        ExchangeRateResponse response = restTemplate.getForObject(apiUrl, ExchangeRateResponse.class);
        if (response != null && response.isSuccess()) {
            Map<String, Double> rates = response.getRates();
            rates.forEach((currency, rate) -> {
                CurrencyExchangeRate currencyExchangeRate = new CurrencyExchangeRate();
                currencyExchangeRate.setCurrency(currency);
                currencyExchangeRate.setRate(rate);
                currencyExchangeRateRepository.save(currencyExchangeRate);
            });
        }
    }

    public double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        CurrencyExchangeRate fromRate = currencyExchangeRateRepository.findByCurrency(fromCurrency);
        CurrencyExchangeRate toRate = currencyExchangeRateRepository.findByCurrency(toCurrency);
        if (fromRate != null && toRate != null) {
            return (amount / fromRate.getRate()) * toRate.getRate();
        }
        return -1; // Indicate conversion failure
    }


    public double getExchangeRate(String sourceCurrency, String targetCurrency) {
        CurrencyExchangeRate sourceRate = currencyExchangeRateRepository.findByCurrency(sourceCurrency);
        CurrencyExchangeRate targetRate = currencyExchangeRateRepository.findByCurrency(targetCurrency);
        if (sourceRate != null && targetRate != null) {
            return targetRate.getRate() / sourceRate.getRate();
        }

        return -1;
    }

}

