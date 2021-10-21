package com.cyn.demo.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
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

    /**
     * String sdfStr = "hh:mm:ssa, E, MMM, dd, yyyy";
     * <p>
     * // E 星期几/英文模式下简写
     * <p>
     * // EEE 星期几/英文模式下全名
     * <p>
     * // M  数字月份 1-12 (en)
     * <p>
     * // MM  数字月份 01-12 (en)
     * <p>
     * // MMM  月份简写 Jan (en)
     * <p>
     * // MMMM  月份全名 January (en)
     */
    @Test
    public void getChineseDate() {
        SimpleDateFormat sdf_chs = new SimpleDateFormat("MMMM,dd,E", Locale.SIMPLIFIED_CHINESE);
        String format = sdf_chs.format(new Date());
        System.out.println(format);
    }
}
