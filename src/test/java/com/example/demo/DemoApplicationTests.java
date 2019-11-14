package com.example.demo;




import com.example.demo.domain.TbGrade;

import net.atomarrow.domains.DomainUtil;
import net.atomarrow.filter.ConfigScanner;
import net.atomarrow.services.Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.*;
@SpringBootTest
class DemoApplicationTests extends Service {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    private ConfigScanner configScanner;
    @Autowired
    private DomainUtil domainUtil;
    @Test
    void testString() {
//操作string
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        opsForValue.set("k1", "value1");//存一个key
        System.out.println("操作成功");
        System.out.println(opsForValue.get("k1"));
//注意 相同的key 会被覆盖,理解成修改
        Map<String, String> map = new HashMap<>();//存放一个map
        map.put("k1", "val1");
        map.put("k2", "val2");
        map.put("k3", "val3");
        map.put("k4", "val4");
        opsForValue.multiSet(map);
        System.out.println("操作成功");
        //取出map中的value
        Collection<String> keys = new ArrayList<>();
        keys.add("k1");
        keys.add("k2");
        keys.add("k3");
        keys.add("k4");
        List<String> list = opsForValue.multiGet(keys);
        for (String val : list
        ) {
            System.out.println(val);
            System.out.println("操作成功");
        }
        opsForValue.set("age", "10");
        //增长
        opsForValue.increment("age");//+1   11
        //降
        opsForValue.decrement("age");//-1    10
    }

    /**
     * 操作list
     * 于振华
     */
 /*   @Test
    void testList() {
        ListOperations<String, String> list = stringRedisTemplate.opsForList();
        //存放
        list.leftPushAll("myList", "b", "c", "d");//放左边 d, c, b
        list.rightPushAll("mykey2", "a", "b", "c"); //放右边a b c
        list.leftPush("myList", "放你一个");//放一个
        String myList = list.leftPop("myList");//取出左边
        List<String> myList1 = list.range("myList", 0, -1);//取出0 到 倒数第一个 也就是全部
        for (String li : myList1) {
            System.out.println(li);
        }
    }*/

    //数据库自动生成domian表
    @Test
    public void initContext() {
        System.out.println("-------------test  start-------------");
        configScanner.scan();
        domainUtil.generateAllSingleTable();

    }


   // @Test
   /* public void print(TbStudent) {
        studentVo.setScoreId(1);
        studentVo.setGradeId("1");
        Conditions conditions = new Conditions(TbStudent.class);

        conditions.setReturnClass(StudentVo);

        conditions.setJoin(" student left join tbgrade grade on student.id = tbgrade.id");
        conditions.putEW("stu.id", studentVo.getGradeId());
        conditions.putEW("sco.id", studentVo.getScoreId());
        System.out.println(conditions);
        System.out.println("hello");
    }
*/
    /**
     * 批量插入  参数是domino类型的集合
     */
    @Test
    public void listGrade() {
     configScanner.scan();
        System.out.println("--批量添加数据--");
        List<TbGrade> grades = new ArrayList<>();
        List list = new ArrayList();
        list.add("一年级");
        list.add("二年级");
        list.add("三年级");
        list.add("四年级");
        list.add("五年级");
        for (int i = 0; i < list.size(); ++i) {
            TbGrade grade = new TbGrade();

            grade.setName((String) list.get(i));
            grades.add(grade);
        }
        boolean b = addByBatch(grades);
        System.out.println(b);
    }
    @Test
    public void byBatch() {
        configScanner.scan();

    }
}
