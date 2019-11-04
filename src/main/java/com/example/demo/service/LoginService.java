package com.example.demo.service;

import com.example.demo.bean.ResultBean;
import com.example.demo.domain.TbAccount;
import com.example.demo.util.DBUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LoginService extends BaseService {
    //登录service
    public ResultBean login(TbAccount tbAccount) {
        TbAccount log = listLogin(tbAccount);
        if (log == null) {
            ResultBean xiaoxixi = BaseService.failure("对不起账户密码错误");
            System.out.println(xiaoxixi.getM());
            return xiaoxixi;
        } else {
            System.out.println(log);
            return success();
        }
    }

    //查询账户密码dao
    public TbAccount listLogin(TbAccount tbAccount) {
        //连接数据库
        String sql = "SELECT * from tbaccount where username = '" + tbAccount.getUsername() + "' and password = '" + tbAccount.getPassword() + "'";
        System.out.println(sql);
        //查询账户
        TbAccount tbAccountDB =null;
        List<Map<String, Object>> list1 = DBUtils.getList(sql);
        if (list1.size()!=0){
            Map<String, Object> map = list1.get(0);
            //遍历Map
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                tbAccountDB = new TbAccount();
                if (entry.getKey().equals("password")){
                    tbAccountDB.setPassword((String) entry.getValue());
                }
                if (entry.getKey().equals("username")){
                    tbAccountDB.setPassword((String) entry.getValue());
                }
            }
        }

        return tbAccountDB;
    }
}

