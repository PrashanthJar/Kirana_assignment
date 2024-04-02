package com.KiranaStore.KiranaStore.service;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import com.KiranaStore.KiranaStore.Response.ExchangeRateResponse;

public interface ExternalApiService {
    public ExchangeRateResponse fetchDataFromExternalApi();
}
