package com.example.oopDepositTask.repo;

import com.example.oopDepositTask.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepo extends JpaRepository<Bank, Long> {
    Bank findBankByBankName(String name);
}
