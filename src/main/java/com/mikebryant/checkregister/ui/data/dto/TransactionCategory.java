package com.mikebryant.checkregister.ui.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class TransactionCategory implements Serializable {
    private String uuid;
    private String description;
    private boolean activeInd;
    private int sortOrder;
    @JsonIgnore
    private List<Transaction> transactions = new ArrayList<>();
}
