package com.KiranaStore.KiranaStore.service.Impl;

import com.KiranaStore.KiranaStore.Response.ExchangeRateResponse;
import com.KiranaStore.KiranaStore.service.ExternalApiService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalApiServiceImpl implements ExternalApiService {
    private final RestTemplate restTemplate;

    public ExternalApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable(cacheManager = "cacheManager",cacheNames = "fetchDataFromExternalApi")
    public ExchangeRateResponse fetchDataFromExternalApi(){
        return restTemplate.getForObject("https://api.fxratesapi.com/latest", ExchangeRateResponse.class);
    }

}
