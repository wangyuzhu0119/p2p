package com.bw.controller;

import com.bw.entity.User;
import com.bw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jwt")
public class JwtController {

    @Autowired
    UserService userService;

//    @RequestMapping("/user")
//    public User userLogin(@RequestBody User user){
//    }

}