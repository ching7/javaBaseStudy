package com.cyn.demo.date;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-06-07
 */
public class CompareAndFormatDate {
    public static String YYYY = "yyyy";

    /**
     * The constant YYYY_MM.
     */
    public static String YYYY_MM = "yyyy-MM";

    /**
     * The constant YYYY_MM_DD.
     */
    public static String YYYYMMDD = "yyyyMMdd";
    /**
     * The constant YYYY_MM_DD.
     */
    public static String YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * The constant YYYYMMDDHHMMSS.
     */
    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    /**
     * The constant YYYYMMDDHHMMSSSSS.
     */
    public static String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";

    /**
     * The constant YYYY_MM_DD_HH_MM_SS.
     */
    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

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

    @Test
    public void testCompare() {
        Date date = new Date();
        String format = new SimpleDateFormat(YYYYMMDD).format(date);
        System.out.println(format);

        Date retryCallTime = new Date(new Date().getTime() + 24 * 60 * 60 * 1000);
        String format2 = new SimpleDateFormat(YYYYMMDD).format(retryCallTime);
        System.out.println(format2);

        int dateFirstIntVal = Integer.parseInt(format);
        int dateLastIntVal = Integer.parseInt(format2);

    }

    @Test
    public void getDifferDay() {
        Date date1 = new Date();
        String format = new SimpleDateFormat(YYYYMMDD).format(date1);
        Date date2 = new Date(new Date().getTime() + 24 * 60 * 60 * 1000);
        long res = (date2.getTime() - date1.getTime()) / (1000 * 3600 * 24);
        int abs = Math.abs((int) (res));

    }
}
