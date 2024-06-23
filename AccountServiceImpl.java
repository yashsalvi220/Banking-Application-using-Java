package net.javaguides.banking.service.impl;

import net.javaguides.banking.dto.Accountdto;
import net.javaguides.banking.entity.account;
import net.javaguides.banking.mapper.Accountmapper;
import net.javaguides.banking.repository.AccountRepository;
import net.javaguides.banking.service.Accountservice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements Accountservice {
    private  AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Accountdto createAccount(Accountdto accountdto) {
        account Account = Accountmapper.mapToAccount(accountdto);
        account Savedaccount = accountRepository.save(Account);
        return Accountmapper.mapToAccountDto(Savedaccount);
    }

    @Override
    public Accountdto getAccountById(Long Id) {
        account Account = accountRepository
                .findById(Id)
                .orElseThrow(() -> new RuntimeException("Account does not exists"));
        return Accountmapper.mapToAccountDto(Account);
    }

    @Override
    public Accountdto deposit(Long Id, double amount) {
        account Account = accountRepository
                .findById(Id)
                .orElseThrow(() -> new RuntimeException("Account does not exists"));

        double total = Account.getBalance() + amount;
        Account.setBalance(total);
        account Savedaccount = accountRepository.save(Account);
        return Accountmapper.mapToAccountDto(Savedaccount);
    }

    @Override
    public Accountdto withdraw(Long Id, double amount) {
        account Account = accountRepository
                .findById(Id)
                .orElseThrow(() -> new RuntimeException("Account does not exists"));
        if(Account.getBalance() < amount) {
            throw new RuntimeException("Insufficient amount");
        }

        double total = Account.getBalance() - amount;
        Account.setBalance(total);
        account Savedaccount = accountRepository.save(Account);
        return Accountmapper.mapToAccountDto(Savedaccount);
    }

    @Override
    public List<Accountdto> getAllAccounts() {
        List<account> accounts = accountRepository.findAll();
        return accounts.stream().map((Account)-> Accountmapper.mapToAccountDto(Account)).collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long Id) {
        account Account = accountRepository
                .findById(Id)
                .orElseThrow(() -> new RuntimeException("Account does not exists"));
        accountRepository.deleteById(Id);
    }
}
