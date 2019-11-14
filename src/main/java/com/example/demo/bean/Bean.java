package com.example.demo.bean;

import com.example.demo.domain.TbGrade;
import com.example.demo.domain.TbStudent;

/**
 * @author 于振华
 * @create 2019-11-13 0:17
 */
public class Bean {
    private TbStudent student;
    private TbGrade grade;

    public TbStudent getStudent() {
        return student;
    }

    public void setStudent(TbStudent student) {
        this.student = student;
    }

    public TbGrade getGrade() {
        return grade;
    }

    public void setGrade(TbGrade grade) {
        this.grade = grade;
    }
}
