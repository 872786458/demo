package com.example.demo.bean;

public class ScoreVo {

    private int id;
    //学生名
    private String names;
    //学生成绩
    private int score;
    //学生年级
    private String grade;
    //学生表id
    private int studentId;
    //班级表id
    private int tbGradeId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getTbGradeId() {
        return tbGradeId;
    }

    public void setTbGradeId(int tbGradeId) {
        this.tbGradeId = tbGradeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "ScoreVo{" +
                "id=" + id +
                ", names='" + names + '\'' +
                ", score=" + score +
                ", grade='" + grade + '\'' +
                ", studentId=" + studentId +
                ", tbGradeId=" + tbGradeId +
                '}';
    }
}
