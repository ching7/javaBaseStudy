package com.cyn.demo.date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-06-18
 */
public class DateTimeChangeDemo {
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
     * The constant YYYY_MM_DD.
     */
    public static String YYYY_MM_DD_HH = "yyyy-MM-dd HH";
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

    @Test
    public void getPastWeakTime() {
        SimpleDateFormat df = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        //上周：-1 ，上2周：-2
        calendar.add(Calendar.WEEK_OF_YEAR, -2);
        //
        System.out.println(df.format(calendar.getTime()));
    }

    @Test
    public void getPastDayTime() {
        SimpleDateFormat df = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        //昨天：-1
        calendar.add(Calendar.DATE, 1);
        System.out.println(df.format(calendar.getTime()));
    }

    @Test
    public void getPastHourTime() {
        SimpleDateFormat df = new SimpleDateFormat(YYYY_MM_DD_HH);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        //昨天：-1
        calendar.add(Calendar.HOUR, -15);
        System.out.println(df.format(calendar.getTime()));
        // mysql dateformat
        /**
         * SELECT DATE_FORMAT(NOW(),'%Y-%m-%d %H') AS '日期';

         select
         from zn_call_history where DATE_FORMAT(updated_time,'%Y-%m-%d %H') > '2021-05-25 15';

         }*/
    }
    @Test
    public void t1() throws ParseException {
        String n = "20220928105615193842";
        Date date = DateUtils.parseDate(n, DateUtils.YYYYMMDDHHMMSSSSS);
        String timestamp = String.valueOf(date.getTime());
        System.out.println(timestamp);
        String time  = DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, date);
        System.out.println(time);
     }
}

