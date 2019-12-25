package com.bw.controller;

import com.bw.entity.User;
import com.bw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/api")
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public Boolean login(@RequestParam("username")String username, @RequestParam("password")String password, HttpServletRequest request , HttpServletResponse response){
        System.out.print("@@@@@@@"+username+","+password);
        return  userService.doLogin(username,password,request,response);
    }

    @RequestMapping("/sso")
    public User sso(HttpServletRequest request, HttpServletResponse response) {
        return userService.sso(request, response);
    }

}
