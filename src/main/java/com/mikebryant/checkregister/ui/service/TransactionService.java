package com.mikebryant.checkregister.ui.service;

import com.mikebryant.checkregister.ui.data.dto.Transaction;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TransactionService {

    @Value("${backend.base-url}")
    private String baseUrl;

    private final RestTemplate restTemplate;

    public TransactionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @CircuitBreaker(name = "transactionService", fallbackMethod = "fallback")
    public List<Transaction> getAllTransactions() {
        ResponseEntity<List<Transaction>> responseEntity =
                restTemplate.exchange(
                        baseUrl + "/transaction",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<>() {
                        }
                );

        return responseEntity.getBody();
    }

    private List<Transaction> fallback(Exception e) {
        e.printStackTrace();

        return new ArrayList<>();
    }
}
