package com.example.demo.controller;

import com.example.demo.domain.TbAccount;
import com.example.demo.service.AccountService;
import net.atomarrow.bean.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 于振华
 * @create 2019-11-08 15:10
 */
@Controller
public class RegisterController {
    @Autowired
    private AccountService accountService;
    //跳转注册页面
    @RequestMapping("/register")
    public String register (){
        return "/register";
    }
    //注册提交
    @RequestMapping("/toRegister")
    @ResponseBody
    public ServiceResult addRegister(TbAccount tbAccount){
        System.out.println(tbAccount.getUsername());
        ServiceResult serviceResult = accountService.addRegister(tbAccount);
        return serviceResult;
    }

}
