package com.example.demo.service;

import com.example.demo.bean.ResultBean;
import com.example.demo.bean.StudentVo;
import com.example.demo.util.DBUtils;
import org.springframework.stereotype.Service;

@Service
public class ScoreService  extends BaseService {
//修改成绩service
    public ResultBean modifyScore(StudentVo studentVo){
        modify(studentVo);
        return success();
    }

    //修改成绩dao
    public void modify(StudentVo studentVo){
        String scoreSql = "UPDATE tbscore SET score = "+ studentVo.getScore()+" WHERE id = "+ studentVo.getScoreId()+"";
        DBUtils.update(scoreSql);

    }
}
