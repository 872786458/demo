package com.example.demo.domain;


import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

@Component
public class TbGrade extends Domain {
    //年级表id
    private Integer id;
    //年级；
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
