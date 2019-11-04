package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    //学生信息管理后台
    @RequestMapping("/admin")
    public Object admin(){
        return "manage";
    }
}
