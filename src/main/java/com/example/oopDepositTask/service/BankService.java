package com.example.oopDepositTask.service;

import com.example.oopDepositTask.model.Bank;
import com.example.oopDepositTask.repo.BankRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BankService {
    private final BankRepo bankRepo;

    public void saveBank(Bank bank) throws IOException {
        log.info("Saving new Bank. id_bank: {}, bankName: {}", bank.getId_bank(), bank.getBankName());
        bankRepo.save(bank);
    }

    public List<Bank> findAllBanks() {
        return bankRepo.findAll();
    }

    public Bank findBankByName(String name){
        return bankRepo.findBankByBankName(name);
    }
}
