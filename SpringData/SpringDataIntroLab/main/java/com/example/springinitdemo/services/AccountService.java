package com.example.springinitdemo.services;

import com.example.springinitdemo.models.User;

import java.math.BigDecimal;

public interface AccountService {
    void withdrawMoney(BigDecimal amount, Long id);

    void depositMoney(BigDecimal amount, Long id);

    void transferMoney(Long accountFrom, Long accountTo, BigDecimal amount);
}
