package com.example.oopDepositTask.service;

import com.example.oopDepositTask.model.Bank;
import com.example.oopDepositTask.model.Img;
import com.example.oopDepositTask.repo.BankRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BankService {
    private final BankRepo bankRepo;

    public List<Bank> findAllBanks() {
        return bankRepo.findAll();
    }

    public Bank findBankByName(String name) {
        return bankRepo.findBankByBankName(name);
    }

    public void saveBank(Bank bank,
                         MultipartFile file) throws IOException {
        Img img;
        if (file.getSize() != 0) {
            img = toImageEntity(file);
            bank.addImageToBank(img);
        }
        log.info("Saving new Bank. id_bank: {}, bankName: {}", bank.getId_bank(), bank.getBankName());
        bankRepo.save(bank);
    }

    private Img toImageEntity(MultipartFile file) throws IOException {
        Img img = new Img();
        img.setName(file.getName());
        img.setOriginalFileName(file.getOriginalFilename());
        img.setContentType(file.getContentType());
        img.setSize(file.getSize());
        img.setBytes(file.getBytes());
        return img;
    }
}
