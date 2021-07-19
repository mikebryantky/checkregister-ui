package com.mikebryant.checkregister.ui.data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class Transaction implements Serializable {
    private String uuid;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate txDate;
    private String description;
    private String checkNumber;
    private Double amount;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate reconciledDate;
    private String notes;
    private TransactionType transactionType;
    private TransactionMethod transactionMethod;
    private TransactionCategory transactionCategory;

}
