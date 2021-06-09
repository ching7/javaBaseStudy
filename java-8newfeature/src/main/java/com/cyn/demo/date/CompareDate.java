package com.cyn.demo.date;

import java.util.Date;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-06-07
 */
public class CompareDate {
    public static void main(String[] args) {
        Date retryCallTime = new Date(new Date().getTime() + 1 * 60 * 60 * 1000);
        int i = new Date().compareTo(retryCallTime);


        Integer i2 = 2;
        Integer i3 = 3;
        Integer i22 = 2;
        int i1 = i2.compareTo(i22);
        int i4 = i2.compareTo(i3);
        int i5 = i3.compareTo(i2);
    }
}
