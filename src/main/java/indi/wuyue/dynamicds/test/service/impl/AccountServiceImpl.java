package indi.wuyue.dynamicds.test.service.impl;

import indi.wuyue.dynamicds.annotation.DS;
import indi.wuyue.dynamicds.test.bean.Account;
import indi.wuyue.dynamicds.test.dao.AccountMapper;
import indi.wuyue.dynamicds.test.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final static Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Resource
    private AccountMapper accountMapper;

    @Override
    public List<Account> listAccounts() {
        LOGGER.info("listAccounts");
        return accountMapper.selectAccounts();
    }

    @Override
    public Account getAccount() {
        LOGGER.info("getAccount");
        return accountMapper.selectOne();
    }

    @Override
    public void addAccount(Account account) {
        LOGGER.info("addAccount");
    }

}
