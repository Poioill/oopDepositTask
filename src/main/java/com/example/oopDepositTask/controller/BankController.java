package com.example.oopDepositTask.controller;

import com.example.oopDepositTask.model.Bank;
import com.example.oopDepositTask.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class BankController {
    public final BankService bankService;

    @PostMapping("/bank/add")
    public String addBank(Bank bank, @RequestParam("file") MultipartFile file) throws IOException {
        bankService.saveBank(bank, file);
        return "redirect:/";
    }

    @GetMapping("/bank/add")
    public String addBank(){
        return "addBank";
    }

    @GetMapping("/{bankName}")
    public String moreAboutBank(@PathVariable String bankName, Model model){
        Bank bank = bankService.findBankByName(bankName);
        model.addAttribute("bank", bank);
        model.addAttribute("image", bank.getImage());
        return "aboutBank";
    }
}
