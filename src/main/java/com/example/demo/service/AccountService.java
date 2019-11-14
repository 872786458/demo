package com.example.demo.service;
import com.example.demo.domain.TbAccount;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.services.Service;
import net.atomarrow.util.MD5;
import org.springframework.stereotype.Component;
;


/**
 * @author 于振华
 * @create 2019-11-04 22:18
 */
@Component
public class AccountService extends Service {
    public String getTableName() {
        return TbAccount.class.getSimpleName();
    }

    /**
     * 用户注册
     *
     * @param
     * @return
     */
    public ServiceResult addRegister(TbAccount account) {
        Conditions condition = new Conditions(getTableName());
        condition.putEW("username", account.getUsername());
        if (checkExist(getTableName(), "username", account.getUsername())) {//检查啊是否存
            return error("账户已经存在");
        }
        String password = account.getPassword();
        String pass = MD5.calcMD5(password);
        account.setPassword(pass);
        add(account);
        return success(true);

    }


}
