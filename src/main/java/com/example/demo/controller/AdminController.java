package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @author 于振华
 * @create 2019-11-04 22:18
 */
@Controller
public class AdminController {
    //学生信息管理后台
    @RequestMapping("/admin")
    public Object admin(){
        return "manage";
    }
}
