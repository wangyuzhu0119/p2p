package com.bw.utils;

import com.bw.entity.User;

import java.math.BigDecimal;
import java.util.Date;

public class MathTest {

    public static void main(String[] args) {

        Integer a = 10000;
        Integer b = 50000;


        Date c = new Date();
        User user = new User();
        user.setUserRegtime(c);
        System.out.println(user.getUserRegtime());

        if(a.compareTo(b)==-1){
            System.out.println("-1");
        }if(a.compareTo(b)==0){
            System.out.println("0");
        }if(a.compareTo(b)==1){
            System.out.println("1");
        }
    }
}
