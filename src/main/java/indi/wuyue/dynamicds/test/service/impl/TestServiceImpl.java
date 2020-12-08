package indi.wuyue.dynamicds.test.service.impl;

import indi.wuyue.dynamicds.annotation.DS;
import indi.wuyue.dynamicds.test.bean.Account;
import indi.wuyue.dynamicds.test.service.AccountService;
import indi.wuyue.dynamicds.test.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    private final static Logger LOGGER = LoggerFactory.getLogger(TestServiceImpl.class);

    @Resource
    private AccountService accountService;

    @Override
    public void testMaster() {
        List<Account> accounts = accountService.listAccounts();
        LOGGER.info("=====");
//        accountService.addAccount(null);
    }

    @Override
    public void testSlave() {
        accountService.listAccounts();
    }


    @Override
    public void testNested() {
        accountService.listAccounts();
        accountService.getAccount();
    }

}
