package com.example.demo.controller;

import com.example.demo.bean.ResultBean;
import com.example.demo.domain.TbAccount;
import com.example.demo.service.LoginService;
import com.example.demo.util.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
//登录页面
    @RequestMapping("/login")
    public Object login() {
        return "Login";
    }
    //后台管理首页
    @RequestMapping("/manage")
    public String manage(){
        return "/manage";

    }

//登陆请求
    @RequestMapping("/log")
    @ResponseBody
    public Object log(TbAccount tbAccount) {
        String password = tbAccount.getPassword();
        String md5Password = Md5Utils.md5Utils(password);
        tbAccount.setPassword(md5Password);
        ResultBean login = loginService.login(tbAccount);
        return login;


    }

}

