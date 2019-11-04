package com.example.demo.service;

import com.example.demo.bean.ResultBean;
import com.example.demo.bean.StudentVo;
import com.example.demo.util.DBUtils;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author 于振华
 * @create 2019-11-04 22:18
 */
@Service
public class StudentsService extends BaseService {
    //录入学生信息
    public ResultBean students(String name, int score, int gradeId) {
        if (name != null && gradeId != 0 && gradeId != 0) {
            addStudents(name, score, gradeId);
            return success();
        } else {
            return failure("录入信息有误");
        }
    }

    //注册学生信息Dao
    public void addStudents(String name, int score, int gradeId) {
        //录入学生成绩
        String scoreSql = "INSERT INTO tbscore(score) VALUES(" + score + ")";
        int scoreId = DBUtils.add_returnId(scoreSql);
        //录入学生姓名
        String nameSql = "INSERT INTO tbstudents(name,gradeId,scoreId) VALUES('" + name + "'," + gradeId + "," + scoreId + ")";
        DBUtils.update(nameSql);


    }

    //查询学生信息service
    public ResultBean getStudents(StudentVo studentVo, int limit, int page) {
        if (studentVo.getName() == null) {
            studentVo.setName("");
        }
        if (studentVo.getGradeId() == null) {
            studentVo.setGradeId("");
        }
        page =(page - 1) *10;
        List<StudentVo> students = listStudents(studentVo,limit,page);
        if (0 != students.size()) {

            ResultBean success = success(students);
            return success;
        } else {
            return failure("没有您查询的信息");
        }

    }

    //返回数据库总数service
    public ResultBean getCount() {
        int totalCount = getTotalCount();

        return success(totalCount);
    }

    //查询学生信息Dao
    public List<StudentVo> listStudents(StudentVo studentVo, int limit, int page) {
        String sql = "SELECT tbstudents.scoreId, tbstudents.name,tbscore.score,tbgrade.grade FROM" +
                " tbscore JOIN tbstudents ON tbscore.id = tbstudents.scoreId JOIN tbgrade ON tbstudents.gradeId = tbgrade.id " +
                "WHERE tbstudents.name LIKE '%" + studentVo.getName() + "%' AND tbstudents.gradeId LIKE '%" + studentVo.getGradeId() + "%' ORDER BY scoreId LIMIT "+page+","+limit+"";
        List getstudentS = DBUtils.getList(sql);
        System.out.println(sql);
        return getstudentS;
    }

    //返回数据库总数dao
    public int getTotalCount() {
        int tbstudents = DBUtils.getCount("tbstudents");

        return tbstudents;
    }

    //删除学生service
    public ResultBean delStudent(int id,int score){
        delStudents(id,score);
        return success();

    }

    //删除学生信息dao
    public  void delStudents(int id,int score){
        String nameSql = "DELETE FROM tbstudents WHERE id = "+id+"";
        String scoreSql = "DELETE FROM tbscore WHERE score = "+score+"";
        DBUtils.update(nameSql);
        DBUtils.update(scoreSql);


    }
    //修改学生信息service
    public ResultBean modifyStudent(StudentVo studentVo){
        modifyStudents(studentVo);
        return success();
    }
    //修改学生信息dao;
    public void modifyStudents(StudentVo studentVo){
        String studentSql = "UPDATE tbstudents SET name = '"+ studentVo.getName()+"',gradeId = "+ studentVo.getGradeId()+" WHERE scoreId = "+ studentVo.getScoreId()+"";
        DBUtils.update(studentSql);

    }




}
