package com.mikebryant.checkregister.ui.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class TransactionMethod implements Serializable {

    public static final String CHECK = "b71b33bf-6326-4ad5-88d9-e72a86f34ef9";

    private String uuid;
    private String description;
    @JsonIgnore
    private List<Transaction> transactions = new ArrayList<>();

}
