package com.mikebryant.checkregister.ui.controller;

import com.mikebryant.checkregister.ui.service.BalanceService;
import com.mikebryant.checkregister.ui.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping({"transaction/list"})
    public String main(Model model) {
        model.addAttribute("transactions", transactionService.getAllTransactions());

        return "transaction/list";
    }

}
