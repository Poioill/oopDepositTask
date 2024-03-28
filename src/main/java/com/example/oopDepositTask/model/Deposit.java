package com.example.oopDepositTask.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String naming;
    private Float interestRate;
    private Boolean additionalDownPayment;
    private Boolean earlyTermination;
    private Boolean monthlyPayout;
    private Boolean capitalization;
    private String additionalInformation;

    @Column(columnDefinition = "text")
    private String details;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Bank bank;

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaming() {
        return naming;
    }

    public void setNaming(String naming) {
        this.naming = naming;
    }

    public Float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Float interestRate) {
        this.interestRate = interestRate;
    }

    public Boolean getAdditionalDownPayment() {
        return additionalDownPayment;
    }

    public void setAdditionalDownPayment(Boolean additionalDownPayment) {
        this.additionalDownPayment = additionalDownPayment;
    }

    public Boolean getEarlyTermination() {
        return earlyTermination;
    }

    public void setEarlyTermination(Boolean earlyTermination) {
        this.earlyTermination = earlyTermination;
    }

    public Boolean getMonthlyPayout() {
        return monthlyPayout;
    }

    public void setMonthlyPayout(Boolean monthlyPayout) {
        this.monthlyPayout = monthlyPayout;
    }

    public Boolean getCapitalization() {
        return capitalization;
    }

    public void setCapitalization(Boolean capitalization) {
        this.capitalization = capitalization;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
