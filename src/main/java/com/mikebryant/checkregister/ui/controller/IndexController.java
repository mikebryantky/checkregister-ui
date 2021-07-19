package com.mikebryant.checkregister.ui.controller;

import com.mikebryant.checkregister.ui.service.BalanceService;
import com.mikebryant.checkregister.ui.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IndexController {
    private final TransactionService transactionService;
    private final BalanceService balanceService;

    public IndexController(TransactionService transactionService,
                           BalanceService balanceService) {
        this.transactionService = transactionService;
        this.balanceService = balanceService;
    }

    @GetMapping({"/", "home"})
    public String main(Model model) {
        model.addAttribute("transactions", transactionService.getAllTransactions());
        model.addAttribute("balance", balanceService.getBalance());

        return "index";
    }

    @GetMapping("notyet")
    public String notyet(Model model) {
        return "notyet";
    }
}
