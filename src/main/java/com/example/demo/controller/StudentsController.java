package com.example.demo.controller;

import com.example.demo.bean.ResultBean;
import com.example.demo.bean.StudentVo;
import com.example.demo.service.ScoreService;
import com.example.demo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class StudentsController {
    @Autowired
    private StudentsService studentsService;
    @Autowired
    private ScoreService scoreService;
    //进入学生信息页面
    @RequestMapping("/stud")
    public Object stud() {
        return "student";
    }
    //查看学生信息
    @RequestMapping("/adminStudents")
    public String adminStudents(){
        return "/adminStudents";
    }
    //注册学生信息
    @ResponseBody
    @RequestMapping("/student")
    public Object students(String name,int score,int gradeId){
        System.out.println("学生信息"+name);
        ResultBean students = studentsService.students(name, score, gradeId);
        return students;

    }



    //查询学生信息
    @RequestMapping("/listStudents")
    @ResponseBody
    public ResultBean listStudents(StudentVo studentVo, int limit, int page){
        ResultBean students = studentsService.getStudents(studentVo,limit,page);
        int count = studentsService.getTotalCount();
        System.out.println(count);
        students.setCount(count);
        return students;
    }
    //数据总数
    @RequestMapping("/listCount")
    @ResponseBody
    public ResultBean listCount(){
        ResultBean count = studentsService.getCount();
        return count;
    }
    //删除学生信息
    @RequestMapping("/delStudent")
    @ResponseBody
    public ResultBean delStudent(int id,int score){
        ResultBean delSuccess = studentsService.delStudent(id, score);
        return delSuccess;
    }
    //修改学生信息
    @RequestMapping("/modifyStudents")
    @ResponseBody
    public ResultBean modifyStudents(StudentVo studentVo){
        ResultBean studentBean = studentsService.modifyStudent(studentVo);
        scoreService.modifyScore(studentVo);
        return studentBean;

    }
}
