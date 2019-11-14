package com.example.demo.controller;

import com.example.demo.domain.TbAccount;
import com.example.demo.service.LoginService;
import net.atomarrow.bean.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 于振华
 * @create 2019-11-08 15:07
 */
@Controller
public class loginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "Login";
    }
    //用户登录

    /**
     * 用户登录
     * @param account
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public ServiceResult login(TbAccount account){
        ServiceResult loginMsg = loginService.login(account);
        return loginMsg;

    }






}
