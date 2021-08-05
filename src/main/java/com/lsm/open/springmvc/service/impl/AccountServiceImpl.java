package com.lsm.open.springmvc.service.impl;


import com.lsm.open.springmvc.dao.AccountDao;
import com.lsm.open.springmvc.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    @Override
    public String one() {
        System.out.println("AccountServiceImpl.one()方法执行");
        return accountDao.one();
    }
}
