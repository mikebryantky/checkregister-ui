package com.mikebryant.checkregister.ui.service;

import com.mikebryant.checkregister.ui.data.dto.Balance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BalanceService {

    public Balance getBalance() {
        Balance balance = new Balance();
        balance.setReconciled(1365.78);
        balance.setUnreconciled(345.34);
        return balance;
    }

}
