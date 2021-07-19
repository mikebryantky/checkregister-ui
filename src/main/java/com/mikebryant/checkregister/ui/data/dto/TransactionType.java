package com.mikebryant.checkregister.ui.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class TransactionType {

    public final static String WITHDRAWAL = "32b1e209-ee18-4340-b00c-b6fa64a80e33";
    public final static String DEPOSIT = "8c8fa709-d826-4613-9fbd-2d9fd6554c1b";

    private String uuid;
    private String description;
    private String color;
    @JsonIgnore
    private List<Transaction> transactions = new ArrayList<>();

}
