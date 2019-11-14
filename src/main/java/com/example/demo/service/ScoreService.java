package com.example.demo.service;

import com.example.demo.domain.TbScore;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.services.Service;
import org.springframework.stereotype.Component;


/**
 * 修改学生成绩
 *
 * @author 于振华
 * @create 2019-11-04 22:18
 */
@Component
public class ScoreService extends Service {
    public ServiceResult modifyScore(TbScore Score) {
        modify(Score);
        return success(true);

    }

}
