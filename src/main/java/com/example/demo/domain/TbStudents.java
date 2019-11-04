package com.example.demo.domain;

public class TbStudents {
    //学生信息表id
    private int id;
    //学生名字
    private String name;
    //学生班级id
    private int gradeId;

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
