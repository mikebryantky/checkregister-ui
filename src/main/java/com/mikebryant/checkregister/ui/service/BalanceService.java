package com.mikebryant.checkregister.ui.service;

import com.mikebryant.checkregister.ui.data.dto.Balance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class BalanceService {
    @Value("${backend.base-url}")
    private String baseUrl;

    private final RestTemplate restTemplate;

    public BalanceService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Balance getBalance() {
        ResponseEntity<Balance> responseEntity = restTemplate.getForEntity(baseUrl + "/balance", Balance.class);

        Balance balance;
        if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
            balance = responseEntity.getBody();
        } else {
            balance = new Balance();
        }

        return balance;
    }

}
