package com.cyn.demo.date;

import org.junit.Test;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-05-28
 */
public class GetWeekTime {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        System.out.println("当前月份：" + Calendar.DAY_OF_MONTH);
        String week;
        week = calendar.get(Calendar.DAY_OF_WEEK) - 1 + "";
        if ("0".equals(week)) {
            week = "7";
        }
        System.out.println("当前星期：" + week);

        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(Calendar.HOUR_OF_DAY);

        //解析成当天的凌晨开始分钟数
        int min = ((int) (calendar.get(Calendar.HOUR_OF_DAY) * TimeUnit.HOURS.toMinutes(1) + Integer.parseInt(String.valueOf(calendar.get(Calendar.MINUTE)))));
        System.out.println("解析成当天的凌晨开始分钟数：" + min);

    }

    /**
     * Gets now week.
     */
    @Test
    public void getNowWeek() {
        Calendar calendar = Calendar.getInstance();
        int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (0 == week) {
            week = 7;
        }
        System.out.println(week);
    }

    /**
     * Gets now HH:MM
     */
    @Test
    public void getHs() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        System.out.println("当前小时：" + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("当前分钟：" + calendar.get(Calendar.MINUTE));

    }
}
