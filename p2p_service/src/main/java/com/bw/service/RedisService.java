package com.bw.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    //存值
    public <T> void set(String key, T obj ,int seconds){
        String json = objToJson(obj);

        redisTemplate.opsForValue().set(key,json,seconds, TimeUnit.SECONDS);
    }
    private <T> String objToJson(T obj) {
        Class<?> clazz = obj.getClass();
        if(clazz==int.class||clazz==Integer.class){
            return String.valueOf(obj);
        }
        if(clazz == String.class){
            return (String)obj;
        }
        String json = JSON.toJSONString(obj);
        return json;
    }
    //取值
    public <T> T  get(String key,Class<T> clazz){
        String json = redisTemplate.opsForValue().get(key);
        T obj = jsonToObj(json,clazz);
        return obj;
    }
    private <T> T jsonToObj(String json,Class<T> clazz){
        if(clazz == String.class){
            return (T)json;
        }
        T obj = JSON.parseObject(json,clazz);
        return obj;
    }
}
