package com.example.oopDepositTask.repo;

import com.example.oopDepositTask.model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositRepo extends JpaRepository<Deposit, Long> {
}
