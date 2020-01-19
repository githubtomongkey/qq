package com.atguigu.springcloud.filter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilterUtil {

    public static String filterIDCode(String s){
        String s1 = s.replaceAll("(\\d{3})(\\d{3})(\\d{8})(\\d{3})([0-9]|X)", "372929189237284965");
       return s1;

    }

    public static void main(String[] args) {
        String dd="137890876659wsyu78";
        String s = filterIDCode(dd);
        System.out.println(s);
    }
}
