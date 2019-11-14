package com.example.demo.util;

import com.example.demo.domain.TbStudent;
import net.atomarrow.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * @author 于振华
 * @create 2019-11-11 22:15
 */
@Component
public class Cache  extends Service {
    @Autowired
   private RedisTemplate redisTemplate;
    /**
     * 普通缓存获取
     *
     * @param key 键
     * @return 值
     */
    public Object get(String key,Object value) {
        Object keyDomain = redisTemplate.opsForValue().get(key);//1.查询redis中是否有数据
        if (keyDomain!=null){
            return keyDomain;
        }
       //2. 获取数据库需要查询的字段
        TbStudent student = getById(TbStudent.class, key);
        redisTemplate.opsForValue().set(key, student);//3,将查询的数据存放到redis中
        return redisTemplate.opsForValue().get(key);//4,返回查询并返回数据
    }

    /**
     * 删除缓存
     * @param key 可以传一个值 或多个
     */
    @SuppressWarnings("unchecked")
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }







}
