package com.example.demo.bean;

import javax.lang.model.element.NestingKind;

public class StudentVo {
    private String name;//学生姓名
    private int score;//学生成绩
    private int grade;//学生班级
    private int scoreId;//学生成绩id
    private String gradeId;//学生班级id

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getScoreId() {
        return scoreId;
    }

    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }

    @Override
    public String toString() {
        return "StudentsVo{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", grade=" + grade +
                ", scoreId=" + scoreId +
                ", gradeId=" + gradeId +
                '}';
    }
}
