package com.example.oopDepositTask.service;

import com.example.oopDepositTask.model.Bank;
import com.example.oopDepositTask.model.Deposit;
import com.example.oopDepositTask.repo.DepositRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class DepositService {
    private final DepositRepo depositRepo;

    public void saveDeposit(Deposit deposit, Bank bank) throws IOException {
        deposit.setBank(bank);
        log.info("Saving new Deposit. naming : {}", deposit.getNaming());
        depositRepo.save(deposit);
    }
}
