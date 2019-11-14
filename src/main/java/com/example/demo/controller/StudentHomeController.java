package com.example.demo.controller;

import com.example.demo.bean.Bean;
import com.example.demo.bean.PageBean;
import com.example.demo.bean.ResultBean;
import com.example.demo.bean.StudentVo;
import com.example.demo.domain.TbScore;
import com.example.demo.domain.TbStudent;
import com.example.demo.service.ScoreService;
import com.example.demo.service.StudentsService;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.render.Render;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStream;
import java.util.List;

/**
 * @author 于振华
 * @create 2019-11-04 22:18
 */
@Controller
@RequestMapping("/student")
public class StudentHomeController extends BaseController {
    @Autowired
    private StudentsService studentsService;
    @Autowired
    private ScoreService scoreService;


    /**
     * 进入学生信息后台管理
     * @return
     */
    @RequestMapping("/toHome")
    public String home() {
        return "home";
    }

    private void print(Bean bean){
        System.out.println(bean.getStudent().getName());
        System.out.println(bean.getGrade().getName());

    }

    /**
     *添加学生页面
     * @return
     */
    @RequestMapping("/to")
    public String toStudent() {
        return "addStudent";
    }
    //添加学生信息

    /**
     * 添加学生能信息
     * @param tbStudent
     * @param tbScore
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public ServiceResult addStudent(TbStudent tbStudent, TbScore tbScore) {
        ServiceResult students = studentsService.students(tbStudent, tbScore);
        return students;
    }


    /**
     * 查看学生信息
     * @return
     */
    @RequestMapping("/toList")
    public String studentList() {
        return "studentList";
    }
    @RequestMapping("/list")
    @ResponseBody
    public ResultBean students(TbStudent tbStudent, TbScore tbScore,PageBean pageBean) {
        List<StudentVo> students = studentsService.getStudents(tbStudent, tbScore,pageBean);
        int count = studentsService.count(tbStudent);
        return success(students,count);
    }

    /**
     * 删除学生信息
     * @param tbStudent
     * @param tbScore
     * @return
     */

    @RequestMapping("/del")
    @ResponseBody
    public ServiceResult delStudent(TbStudent tbStudent,TbScore tbScore){
        ServiceResult serviceResult = studentsService.delStudent(tbStudent, tbScore);
        return serviceResult;

    }


    /**
     * 修改学生信息
     * @param tbStudent
     * @param tbScore
     * @return
     */
    @RequestMapping("/modify")
    @ResponseBody
    public ServiceResult modifyStudent(TbStudent tbStudent,TbScore tbScore){
        System.out.println(tbScore.getName());
        studentsService.modifyStudent(tbStudent);
        ServiceResult serviceResult = scoreService.modifyScore(tbScore);
        return serviceResult;
    }
    /**
     * 导出Excel表格
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/doExcel")
    @ResponseBody
    public Render doExcel(TbStudent student, TbScore score, PageBean pageBean) throws Throwable {
        InputStream inputStream = studentsService.excel(student,score,pageBean );
        return Render.renderFile("学生信息表.xls", inputStream);
    }

}
