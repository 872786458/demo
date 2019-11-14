package com.example.demo;


import com.example.demo.domain.TbGrade;
import com.example.demo.domain.TbStudent;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.domains.DomainUtil;
import net.atomarrow.filter.ConfigScanner;
import net.atomarrow.services.Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class AtomarrowtextApplicationTests extends Service {
    @Autowired
    DomainUtil domainUtil = new DomainUtil();
    @Autowired
    ConfigScanner configScanner = new ConfigScanner();

    @Test
    void contextLoads() {
        System.out.println("--创建表--");
        configScanner.scan();
        domainUtil.generateAllSingleTable();

        System.out.println("--查询数据库age字段有几条15的数据--");
        Conditions conditions=new Conditions(TbStudent.class);
        conditions.putEW("age", 15);
        int count = getCount(conditions);
        System.out.println(count);

        System.out.println("--批量添加数据--");
        List<TbGrade> grades=new ArrayList<>();
        List list=new ArrayList();
        list.add("一年级");
        list.add("二年级");
        list.add("三年级");
        list.add("四年级");
        list.add("五年级");
        for (int i=0;i<list.size();++i){
            TbGrade grade=new TbGrade();
            grade.setName((String) list.get(i));
            grades.add(grade);
        }
        boolean b = addByBatch(grades);
        System.out.println(b);

        System.out.println("--查询id,返回对象，对象里存放查询id的数据--");
        TbGrade byId = getById(TbGrade.class, 1);
        System.out.println(byId.getName());

        System.out.println("--查询符合条件（列）的数据并返回list--");
        Conditions conditions1=new Conditions(TbGrade.class);
        conditions1.putEW("grade","五年级");
        List<Object> grade = getColumnList(conditions1, "id");
        for ( Object o:grade
             ) {
            System.out.println(o);
        }
        System.out.println("--查询条件后去重，返回list集合--");
        Conditions conditions2=new Conditions(TbGrade.class);
        List<Object> grade1 = getColumnDistinctList(conditions2, "grade");
        for ( Object o:grade1
        ) {
            System.out.println(o);
        }
        System.out.println("--修改，需要id--");
        TbGrade tbGrade=new TbGrade();
        Conditions conditions3=new Conditions(TbGrade.class);
        tbGrade.setId(1);
        tbGrade.setName("六年级");
        int modify = modify(tbGrade);
        System.out.println(modify);

        System.out.println("--删除--");
        TbGrade tbGrade1=new TbGrade();
        tbGrade1.setId(1);
        int del = del(tbGrade1);
        System.out.println(del);

    }


}
