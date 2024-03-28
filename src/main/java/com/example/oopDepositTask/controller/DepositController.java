package com.example.oopDepositTask.controller;

import com.example.oopDepositTask.model.Bank;
import com.example.oopDepositTask.model.Deposit;
import com.example.oopDepositTask.service.BankService;
import com.example.oopDepositTask.service.DepositService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class DepositController {
    private final DepositService depositService;
    private final BankService bankService;

    @PostMapping("/{bankName}/deposit/add")
    public String addDeposit(@PathVariable String bankName, Deposit deposit, Model model) throws IOException {
        Bank bank = bankService.findBankByName(bankName);
        depositService.saveDeposit(deposit, bank);
        model.addAttribute("bank", bank);
        return "redirect:/";
    }
}
