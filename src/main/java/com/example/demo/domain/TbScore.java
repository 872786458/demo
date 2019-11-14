package com.example.demo.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

@Component
public class TbScore  extends Domain {
    //成绩id
    private Integer id;
    //成绩
    private Integer name;
    //学生信息id
    private Integer studentId;
    //学生班级id
    private String gradeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }
}
