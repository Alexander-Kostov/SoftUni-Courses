package com.example.springinitdemo.services;

import com.example.springinitdemo.exceptions.EntityMissingException;
import com.example.springinitdemo.models.Account;
import com.example.springinitdemo.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal amount, Long id) {
        Optional<Account> account = this.accountRepository.findById(id);

        if (account.isEmpty()) {
            throw new EntityMissingException("No such account");
        }

        BigDecimal currentBalance = account.get().getBalance();

        if (amount.compareTo(currentBalance) > 0) {
            throw new RuntimeException("cannot withdraw");
        }
        account.get().setBalance(currentBalance.subtract(amount));

        this.accountRepository.save(account.get());
    }


    @Override
    public void depositMoney(BigDecimal amount, Long id) {
        Account account = this.accountRepository.findById(id).
                orElseThrow(() -> new RuntimeException("No such account"));

        BigDecimal balance = account.getBalance().add(amount);
        account.setBalance(balance);

        this.accountRepository.save(account);
    }

    @Override
    public void transferMoney(Long accountFrom, Long accountTo, BigDecimal amount) {

    }
}
