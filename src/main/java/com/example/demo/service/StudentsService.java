package com.example.demo.service;

import com.example.demo.bean.PageBean;
import com.example.demo.bean.StudentVo;
import com.example.demo.domain.TbScore;
import com.example.demo.domain.TbStudent;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.db.parser.JdbcParser;
import net.atomarrow.services.Service;
import net.atomarrow.util.excel.ExcelDataChangeListener;
import net.atomarrow.util.excel.ExcelDatas;
import net.atomarrow.util.excel.ExcelFormatListener;
import net.atomarrow.util.excel.ExcelUtil;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

/**
 * @author 于振华
 * @create 2019-11-04 22:18
 */
@Component
public class StudentsService extends Service {
    /**
     * 录入学生信息
     *
     * @param tbStudent
     * @param tbScore
     * @return
     */
    public ServiceResult students(TbStudent tbStudent, TbScore tbScore) {
        if (tbStudent.getName() != null && tbScore.getName() != 0) {
            add(tbStudent);
            Conditions conditions = new Conditions(TbStudent.class);
            conditions.putEW("name", tbStudent.getName());
            TbStudent student = getOne(conditions);
            tbScore.setStudentId(student.getId());
            add(tbScore);
            return success(true);
        } else {
            return error("录入失败");
        }
    }

    /**
     * 查询学生信息
     *
     * @param tbStudent
     * @param tbScore
     * @return
     */
    public List<StudentVo> getStudents(TbStudent tbStudent, TbScore tbScore, PageBean pageBean) {
        if (tbStudent.getName() == null) {
            tbStudent.setName("");
        }
        if (tbScore.getGradeId() == null) {
            tbScore.setGradeId("");
        }
        Conditions conditions = new Conditions(TbStudent.class);
        conditions.setReturnClass(StudentVo.class);
        conditions.setSelectValue("score.studentId,student.name,score.name,grade.name,grade.id as gradeId");
        conditions.setJoin(" student join TbScore  score on score.studentId = student.id join tbgrade as grade on score.gradeId = grade.id");
        conditions.putLIKE("student.name", tbStudent.getName());
        conditions.putLIKE("score.gradeId", tbScore.getGradeId());
        //排序
        conditions.putASC("score.studentId");
        int count = getCount(conditions);
        System.out.println(count + "数据总数");

        //分页
        Pager pager = new Pager();
        System.out.println(pageBean.getPage() + "当前页");
        System.out.println(pageBean.getLimit() + "当前数据");
        pager.setCurrentPage(pageBean.getPage());
        pager.setPageSize(pageBean.getLimit());
        List<StudentVo> listByPage = getListByPage(conditions, pager);
        System.out.println(JdbcParser.getInstance().getSelectHql(conditions));
        return listByPage;
    }

    /**
     * 查询数据总数
     * @param tbStudent
     * @return
     */
     public int count (TbStudent tbStudent){
         Conditions conditions = new Conditions(TbStudent.class);
         int count = getCount(conditions);
         return count;

     }

    /**
     * 删除学生信息
     *
     * @param tbStudent
     * @param tbScore
     * @return
     */
    public ServiceResult delStudent(TbStudent tbStudent, TbScore tbScore) {
        // Conditions conditions = new Conditions(TbScore.class);
        del(tbStudent);
        del(tbScore);
        return success(true);
    }

    /**
     * 修改学生姓名
     *
     * @param tbStudent
     * @return
     */
    public ServiceResult modifyStudent(TbStudent tbStudent) {
        modify(tbStudent);
        return success(true);
    }

    /**
     * 导出学生表格
     *
     * @param
     * @return
     */
    public InputStream excel(TbStudent tbStudent, TbScore tbScore, PageBean pageBean) {
        ExcelDatas excelDatas = new ExcelDatas();
        //获取导出数据
        List<StudentVo> list = getStudents(tbStudent, tbScore, pageBean);
        excelDatas.addStringArray(0, 0, new String[]{"编号", "姓名", "成绩"});
        excelDatas.addObjectList(1, 0, list, new String[]{"studentId", "name", "score"
                , "grade"});//行,列,集合
       /* excelDatas.addFormatListerner(new ExcelFormatListener() {
            @Override
            public Object changeValue(String fieldName, Object fieldValue, int currentRow, int currentCol) {
                if(fieldName.equals("gradeName")){
                    fieldValue="精英"+fieldValue;
                }
                return fieldValue;
            }
        });*/
       /* excelDatas.addDataChanger(new ExcelDataChangeListener() {
         @Override
            public Object changeValue(String fieldName, Object domain, int currentRow, int currentCol) {
                if(fieldName.equals("address")){
                    StudentScoreBean student = (StudentScoreBean)domain;
                    if(student.getAddress().equals("威海市")){
                        student.setChinese(1000);
                    }
                }
                return null;
            }
        });*/
        InputStream inputStream = ExcelUtil.exportExcel(excelDatas);
        return inputStream;

    }


}
