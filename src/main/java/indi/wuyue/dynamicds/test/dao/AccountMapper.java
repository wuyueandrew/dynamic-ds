package indi.wuyue.dynamicds.test.dao;

import indi.wuyue.dynamicds.annotation.DS;
import indi.wuyue.dynamicds.test.bean.Account;

import java.util.List;

public interface AccountMapper {

    @DS("slave1")
    List<Account> selectAccounts();

    Account selectOne();

}
