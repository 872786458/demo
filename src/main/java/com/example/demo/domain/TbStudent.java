package com.example.demo.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

@Component
public class TbStudent extends Domain {
    //学生信息表id
    private Integer id;
    //学生名字
    private String name;
    //学生班级id
    private Integer gradeId;

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
