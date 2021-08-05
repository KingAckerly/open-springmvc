package com.lsm.open.springmvc.controller;


import com.lsm.open.springmvc.domain.User;
import com.lsm.open.springmvc.framework.util.RequestMapping;
import com.lsm.open.springmvc.service.AccountService;


public class AccountController {

    private AccountService accountService;

    /**
     * 查询一条记录
     * 定义注解,通过注解标记当前方法处理的请求地址
     *
     * @return
     */
    @RequestMapping(value = "/account/one")
    public String one() {
        System.out.println("执行了one!");
        String result = accountService.one();
        return "/WEB-INF/pages/one.jsp";
    }

    /**
     * 查询一条记录
     * 定义注解,通过注解标记当前方法处理的请求地址
     *
     * @return
     */
    @RequestMapping(value = "/account/info")
    public User info() {
        User user = new User();
        user.setName("王五");
        user.setAddress("深圳");
        return user;
    }
}
