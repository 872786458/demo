package com.example.demo.controller;

import com.example.demo.bean.ResultBean;
import com.example.demo.service.AccountService;
import com.example.demo.util.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;
    //跳转注册页面
    @RequestMapping("/register")
    public Object register(){
        return "register";
    }
    /**
     *
     * @param username
     * @param password
     * @return
     */
    //注册账户请求
    @RequestMapping("/doRegister")
    @ResponseBody
    public Object registers(String username,String password){
        System.out.println(username);
        String pass = Md5Utils.md5Utils(password);
        ResultBean account = accountService.addRegister(username, pass);
        return account;
    }

}
