package com.example.oopDepositTask.controller;

import com.example.oopDepositTask.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final BankService bankService;

    @GetMapping("/")
    public String getHome(Model model){
        model.addAttribute("banks", bankService.findAllBanks());
        return "home";
    }

}
