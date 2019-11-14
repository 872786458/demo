package com.example.demo.service;

import com.example.demo.domain.TbAccount;

import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.services.Service;
import org.springframework.stereotype.Component;

/**
 * @author 于振华
 * @create 2019-11-08 21:07
 */
@Component
public class LoginService extends Service {
    public String getTableName(){
        return TbAccount.class.getSimpleName();
    }
    public ServiceResult login(TbAccount account){
        Conditions conditions = new Conditions(getTableName());
         conditions.putEW("username", account.getUsername());
        if (getOne(conditions)!=null){
            return success(true);
        }else {
            return error("用户名密码错误");
        }



    }
}
