package com.bw.service;

import com.bw.entity.User;
import com.bw.mapper.UserMapper;
import com.bw.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisServiceTest {

    @Autowired
    private RedisService redisService;
    @Autowired
    private UserMapper userMapper;

    @Test
    public void set() {
    }

    @Test
    public void get() {
    }

    @Test
    public void test1(){

        User wang = userMapper.login("wang");
        System.out.print("@@@@@@@@@@@@@"+wang);
    }
}
