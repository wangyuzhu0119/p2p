package com.bw.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static Date getDateAfter(Date  date) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + 30);
        return now.getTime();
    }


    public static void main(String[] args) throws ParseException {
        Date returnDate = new Date(); //获取当前时间
        //for循环期数 = 第几期      循环每期的还款截止日期,从第一期开始
        for (Integer i=1;i<=6;i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(returnDate);
            calendar.add(Calendar.DATE,30);
            returnDate =  calendar.getTime();
            System.out.println(returnDate);
        }

    }

}
