package net.javaguides.banking.service;

import net.javaguides.banking.dto.Accountdto;

import java.util.List;

public interface Accountservice {
    Accountdto createAccount (Accountdto accountdto);

    Accountdto getAccountById(Long Id);

    Accountdto deposit(Long Id, double amount);

    Accountdto withdraw(Long Id, double amount);
    List<Accountdto> getAllAccounts();
    void deleteAccount (Long Id);

}
