package com.lsm.open.springmvc.dao.impl;

import com.lsm.open.springmvc.dao.AccountDao;

public class AccountDaoImpl implements AccountDao {

    /**
     * 查询
     *
     * @return
     */
    @Override
    public String one() {
        System.out.println("Dao查询！");
        return "ok";
    }
}
