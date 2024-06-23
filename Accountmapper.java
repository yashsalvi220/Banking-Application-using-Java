package net.javaguides.banking.mapper;

import net.javaguides.banking.dto.Accountdto;
import net.javaguides.banking.entity.account;

public class Accountmapper {
    public static account mapToAccount(Accountdto accountdto){
        account Account = new account(
                accountdto.getId(),
                accountdto.getAccountholdername(),
                accountdto.getBalance()
        );
        return Account;
    }
    public static Accountdto mapToAccountDto (account Account){
        Accountdto accountdto = new Accountdto(
                Account.getId(),
                Account.getAccountholdername(),
                Account.getBalance()
        );
        return accountdto;
    }
}
