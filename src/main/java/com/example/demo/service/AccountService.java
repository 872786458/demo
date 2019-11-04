package com.example.demo.service;

import com.example.demo.bean.ResultBean;

import com.example.demo.util.DBUtils;
import org.springframework.stereotype.Service;


@Service
public class AccountService extends BaseService {
//用户注册/

    /**
     *
     * @param username
     * @param password
     * @return
     */
    public ResultBean addRegister(String username,String password){

        if (username==null||password==null){

            return failure("账户名密码不能为空");
        }else{
            addRegisters(username,password);
            return success();
        }

    }


    //注册账户dao
    public void addRegisters(String username,String password){
        String sql="INSERT INTO tbaccount(username,password) VALUES('"+username+"','"+password+"')";
        System.out.println(sql);
        DBUtils.update(sql);
    }
}
