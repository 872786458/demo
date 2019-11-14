package com.example.demo.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

@Component
public class TbAccount extends Domain {
    //注册账户
    private  Integer id;
    //账户名
    private String username;
    //账户密码
    private String password;

    /**
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
