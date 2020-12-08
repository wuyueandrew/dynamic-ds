package indi.wuyue.dynamicds.test.service;

import indi.wuyue.dynamicds.test.bean.Account;

import java.util.List;

public interface AccountService {

    List<Account> listAccounts();

    Account getAccount();

    void addAccount(Account account);

}
