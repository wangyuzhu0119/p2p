package com.bw.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5Utils {

    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }

    public static void main(String[] args) {
        String pwd = "990119";
        System.out.print(Md5Utils.md5(pwd));
    }

}
