package com.cyn.demo.date;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.io.Serializable;
import java.lang.management.ManagementFactory;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 时间工具类
 *
 * @author coco
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
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
     * The constant YYYY_MM_DD_HH.
     */
    public static String YYYY_MM_DD_HH = "yyyy-MM-dd HH";

    /**
     * The constant YYYY_MM_DD.
     */
    public static String YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * The constant YYYYMMDDHHMMSS.
     */
    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    /**
     * The constant YYYYMMDDHHMM.
     */
    public static String YYYYMMDDHHMM = "yyyyMMddHHmm";
    /**
     * The constant YYYYMMDDHHMMSSSSS.
     */
    public static String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";

    /**
     * The constant YYYY_MM_DD_HH_MM_SS.
     */
    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    /**
     * 获取当前Date型日期
     *
     * @return Date() 当前日期
     */
    public static Date getNowDate() {
        return new Date();
    }


    public static Date nowDateTime() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static Date nowDateTimeAdd(long addTime) {
        return new Timestamp(System.currentTimeMillis() + addTime);
    }

    /**
     * 获取当前日期, 默认格式为yyyy-MM-dd
     *
     * @return String date
     */
    public static String getDate() {
        return dateTimeNow(YYYY_MM_DD);
    }

    /**
     * 获取 当前时间前或后几天的 YYYYMMDD 格式字符串
     *
     * @param
     * @return
     */
    public static String getYyyyMmDd(int dayNum) {
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        c.set(Calendar.DAY_OF_MONTH, day + dayNum);
        Date time = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDD);
        return sdf.format(time);
    }

    /**
     * 获取当前时间一个月前的时间YYYYMMDD 格式字符串
     *
     * @param
     * @return
     */
    public static String getOneMonthBefore() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, c.get(Calendar.MONTH) - 1);
        Date day = c.getTime();
        String time = new SimpleDateFormat(YYYY_MM_DD).format(day);
        return time;
    }

    /**
     * 获取本周开始时间YYYYMMDD 格式字符串
     *
     * @param
     * @return
     */
    public static String getBeginDayOfWeek() {
        Date date = new Date();
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int weekDay = cal.get(Calendar.DAY_OF_WEEK);
        if (weekDay == 1) {
            weekDay += 7;
        }
        cal.add(Calendar.DATE, 2 - weekDay);
        String time = new SimpleDateFormat(YYYY_MM_DD).format(cal.getTime());
        return time;
    }


    /**
     * 获取本月第一天   yyyy-MM-dd 格式
     *
     * @param
     * @return
     */
    public static String getFirstDayOfMonth() {
        Calendar cale = Calendar.getInstance();
        // 第一天
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        String firstDay = dateTime(cale.getTime());
        return firstDay;
    }

    /**
     * 获取当前时间一个月前的时间Date 格式
     *
     * @param
     * @return
     */
    public static Date getOneMonthDateBefore() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, c.get(Calendar.MONTH) - 1);
        Date day = c.getTime();
        return day;
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public static final String getTime() {
        return dateTimeNow(YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * Date time now string.
     *
     * @return the string
     */
    public static final String dateTimeNow() {
        return dateTimeNow(YYYYMMDDHHMMSS);
    }

    /**
     * Date time now string.
     *
     * @param format the format
     * @return the string
     */
    public static final String dateTimeNow(final String format) {
        return parseDateToStr(format, new Date());
    }

    /**
     * Date time string.
     *
     * @param date the date
     * @return the string
     */
    public static final String dateTime(final Date date) {
        return parseDateToStr(YYYY_MM_DD, date);
    }

    /**
     * 获取毫秒级别的时间字符串
     *
     * @param date
     * @return
     */
    public static final String dateTimeSSS(final Date date) {
        return parseDateToStr(YYYYMMDDHHMMSSSSS, date);
    }

    /**
     * Parse date to str string.
     *
     * @param format the format
     * @param date   the date
     * @return the string
     */
    public static final String parseDateToStr(String format, final Date date) {
        if (null == date) {
            return null;
        }
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * Format date.
     *
     * @param format the format
     * @param ts     the ts
     * @return the date
     */
    public static final Date format(final String format, final String ts) {
        try {
            return new SimpleDateFormat(format).parse(ts);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Format date.
     *
     * @param ts the ts
     * @return the date
     */
    public static final Date format(final String ts) {
        try {
            return new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS).parse(ts);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Date time date.
     *
     * @param format the format
     * @param ts     the ts
     * @return the date
     */
    public static final Date dateTime(final String format, final String ts) {
        try {
            return new SimpleDateFormat(format).parse(ts);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 日期路径 即年/月/日 如2018/08/08
     *
     * @return the string
     */
    public static final String datePath() {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyy/MM/dd");
    }

    /**
     * 日期路径 即年/月/日 如20180808
     *
     * @return the string
     */
    public static final String dateTime() {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyyMMdd");
    }

    /**
     * 日期型字符串转化为日期 格式
     *
     * @param str the str
     * @return the date
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 将 sourceFormat 格式的日期字符串 转换为 distFormat 格式的日期字符串
     *
     * @param dataStr
     * @param sourceFormat
     * @param distFormat
     * @return
     */
    public static String parseDate(String dataStr, String sourceFormat, String distFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(sourceFormat);
        try {
            Date date = sdf.parse(dataStr);
            return parseDateToStr(distFormat, date);
        } catch (ParseException e) {
            return null;
        }
    }


    /**
     * 获取服务器启动时间
     *
     * @return the server start date
     */
    public static Date getServerStartDate() {
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }

    /**
     * 计算相差天数
     *
     * @param date1 the date 1
     * @param date2 the date 2
     * @return the int
     */
    public static int differentDaysByMillisecond(Date date1, Date date2) {
        return Math.abs((int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24)));
    }

    /**
     * 计算两个时间差
     *
     * @param endDate the end date
     * @param nowDate the now date
     * @return the date poor
     */
    public static String getDatePoor(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟";
    }

    public static long Date2Second(Date endDate, Date nowDate) {
        // 获得两个时间的毫秒时间差异
        long sec = 0L;
        if (endDate != null && nowDate != null) {
            long diff = endDate.getTime() - nowDate.getTime();
            sec = diff / 1000;

        }
        return sec;
    }


    /**
     * 计算两个时间差
     *
     * @param endDate the end date
     * @param nowDate the now date
     * @return the date poor
     */
    public static String getDateDiff(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();

        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        long sec = diff % nd % nh % nm / ns;
        String timeStr = hour + ":" + min + ":" + sec;
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");// 初始化Formatter的转换格式。
        Date time;
        try {
            time = formatter.parse(timeStr);
        } catch (ParseException e) {
            return null;
        }
        return formatter.format(time);
    }

    /**
     * 计算两个时间差
     *
     * @param startDateStr the start date str
     * @param endDateStr   the end date str
     * @return the date poor
     */
    public static int getDateDiff(String startDateStr, String endDateStr) {
        // 获得两个时间的秒时间差异
        // 初始化Formatter的转换格式。
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            long startDate = formatter.parse(startDateStr).getTime();
            long endDate = formatter.parse(endDateStr).getTime();
            return (int) ((endDate - startDate) / 1000);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 计算两个时间差
     * <p>
     * the end date
     * the now date
     *
     * @return the date poor
     */
    public static String timeConversion(long diff) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;

        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        long sec = diff % nd % nh % nm / ns;
        String timeStr = hour + ":" + min + ":" + sec;
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");// 初始化Formatter的转换格式。
        Date time;
        try {
            time = formatter.parse(timeStr);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            return null;
        }

        return formatter.format(time);

    }

    /**
     * 秒转时分秒
     *
     * @param diff the second
     * @return the date poor
     */
    public static String timeConversion1(int diff) {
        int sd = 24 * 60 * 60;
        int sh = 60 * 60;
        int sm = 60;
        int ss = 1;

        // 计算差多少小时
        int hour = diff % sd / sh;
        // 计算差多少分钟
        int min = diff % sd % sh / sm;
        // 计算差多少秒//输出结果
        int sec = diff % sd % sh % sm / ss;
        String timeStr = hour + ":" + min + ":" + sec;
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");// 初始化Formatter的转换格式。
        Date time;
        try {
            time = formatter.parse(timeStr);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            return null;
        }

        return formatter.format(time);

    }


    /**
     * 获取几天前的时间戳
     *
     * @param NumberOfDays the number of days
     * @return long
     */
    public static long NumberOfDaysStartUnixTime(int NumberOfDays) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH) - NumberOfDays, 0, 0, 0);
        long yesterdayStart = calendar.getTimeInMillis();
        return yesterdayStart;
    }

    /**
     * Check boolean.
     *
     * @param c the c
     * @return boolean
     */
    public static boolean check(char c) {
        Pattern pattern = Pattern.compile("\\pP");
        Matcher matcher = pattern.matcher(String.valueOf(c));
        if (matcher.matches()) {
            return true;

        }
        return false;
    }

    /**
     * Gets last weak time.
     *
     * @param date the date
     * @return the last weak time
     */
    public static String getLastWeakTime(Date date) {
        SimpleDateFormat df = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_YEAR, -1);
        date = calendar.getTime();
        return df.format(date);
    }

    public static String getNextTime(Date date, Integer second) {
        SimpleDateFormat df = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, second);
        date = calendar.getTime();
        return df.format(date);
    }

    /**
     * Gets last day.
     *
     * @param date the date
     * @param day  the day
     * @return the last day
     */
    public static String getLastDay(Date date, Integer day) {
        SimpleDateFormat df = new SimpleDateFormat(YYYY_MM_DD);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        date = calendar.getTime();
        return df.format(date);
    }

    /**
     * 获取前一天的数据
     */
    public static String getDayBefore(Date date) {
        SimpleDateFormat df = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        return df.format(dateRoll(new Date(), Calendar.HOUR, -24));
    }

    //当前时间往前推N小时
    public static Date dateRoll(Date date, int i, int d) {
        // 获取Calendar对象并以传进来的时间为准
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // 将现在的时间滚动固定时长,转换为Date类型赋值
        calendar.add(i, d);
        // 转换为Date类型再赋值
        date = calendar.getTime();
        return date;
    }

    /**
     * 从当天的凌晨开始分钟数
     *
     * @return the now minute
     */
    public static int getNowMinute() {
        Calendar calendar = Calendar.getInstance();
        //从当天的凌晨开始分钟数
        return ((int) (calendar.get(Calendar.HOUR_OF_DAY) * TimeUnit.HOURS.toMinutes(1) + Integer.parseInt(String.valueOf(calendar.get(Calendar.MINUTE)))));
    }


    /**
     * Gets now week.
     * 1-7
     *
     * @return the now week
     */
    public static int getNowWeek() {
        Calendar calendar = Calendar.getInstance();
        int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (0 == week) {
            week = 7;
        }
        return week;
    }

    /**
     * 输入日期，返回当前日期是周几
     *
     * @param date
     * @return
     */
    public static int getWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (0 == week) {
            week = 7;
        }
        return week;
    }


    /**
     * Gets now hour.
     * 0-23
     *
     * @return the now hour
     */
    public static int getNowHour() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_WEEK);
    }


    /**
     * Gets now hour minute.
     * 0-59
     *
     * @return the now hour minute
     */
    public static int getNowHourMinute() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MINUTE);
    }

    public static final String parseDateToStr(final Date date) {
        return parseDateToStr(YYYY_MM_DD_HH_MM_SS, date);
    }

    /**
     * 获取几天后0时0分0秒的时间
     *
     * @return
     */
    public static Date getNextDay0Hour(int nextDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DATE, nextDay); //当前日期加一
        return calendar.getTime();
    }

    /**
     * 获取今天0时0分0秒的时间
     *
     * @return
     */
    public static Date getToday0Hour() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取今天23时59分59秒的时间
     *
     * @return
     */
    public static Date getToday24Hour() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * 获取0时0分0秒的时间
     *
     * @return
     */
    public static Date get0Hour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取23时59分59秒的时间
     *
     * @return
     */
    public static Date get24Hour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * 获取开始、结束时间内的日期<br/>
     * 传入 2021-11-01, 2021-11-07<br/>
     * 返回["2021-11-01","2021-11-02","2021-11-03","2021-11-04","2021-11-05","2021-11-06","2021-11-07"]
     *
     * @param start
     * @param end
     * @return
     */
    public static List<String> getDateInterval(String start, String end) {
        Date startTime = DateUtils.format(DateUtils.YYYY_MM_DD, start);
        Date endTime = DateUtils.format(DateUtils.YYYY_MM_DD, end);
        start = DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD, startTime);
        end = DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD, endTime);
        List<String> dateList = Lists.newArrayList();
        dateList.add(start);
        int i = 1;
        while (true) {
            String lastDay = DateUtils.getLastDay(startTime, i);
            dateList.add(lastDay);
            if (lastDay.equals(end)) {
                break;
            }
            i++;
            if (i > 999) {
                break;
            }
        }
        return dateList;
    }

    /**
     * <pre>
     * 输入 开始、结束分钟数
     * 返回 以半小时为单位截取
     *
     * 例子
     * 输入  600, 780
     * 返回  ["10:00-10:30","10:30-11:00","11:00-11:30","11:30-12:00","12:00-12:30","12:30-13:00"]
     * </pre>
     */
    public static List<HalfWorkTime> min2HalfWime(Integer startMin, Integer endMin) {
        List<HalfWorkTime> hlafWorkTimes = new ArrayList<HalfWorkTime>();
        while (true) {
            if (startMin + 30 > endMin) {
                break;
            }
            HalfWorkTime hwt = new HalfWorkTime();
            hwt.setStart(startMin);
            hwt.setEnd(startMin + 30);
            hwt.setTimeStr(min2Time(hwt.getStart()) + "-" + min2Time(hwt.getEnd()));
            hlafWorkTimes.add(hwt);
            startMin = startMin + 30;
        }
        return hlafWorkTimes;
    }

    /**
     * 分钟数转时间 600 -> 10:00
     */
    public static String min2Time(Integer t) {
        int time = t.intValue();
        int hours = (int) Math.floor(time / 60);
        int minute = time % 60;
        String h = String.valueOf(hours);
        h = h.length() == 1 ? "0" + h : h;
        String m = String.valueOf(minute);
        m = m.length() == 1 ? "0" + m : m;
        return h + ":" + m;
    }

    /**
     * 计算相差分钟数
     *
     * @param date1 the date 1
     * @param date2 the date 2
     * @return the int
     */
    public static int differentMinutesByMillisecond(Date date1, Date date2) {
        return Math.abs((int) ((date2.getTime() - date1.getTime()) / (1000 * 60)));
    }

    public static class HalfWorkTime implements Serializable {

        private static final long serialVersionUID = 1398593368820803627L;

        private Integer start;

        private Integer end;

        private String timeStr;

        public Integer getStart() {
            return start;
        }

        public void setStart(Integer start) {
            this.start = start;
        }

        public Integer getEnd() {
            return end;
        }

        public void setEnd(Integer end) {
            this.end = end;
        }

        public String getTimeStr() {
            return timeStr;
        }

        public void setTimeStr(String timeStr) {
            this.timeStr = timeStr;
        }

    }

    /**
     * 获取时间字符串的时间戳
     *
     * @param time
     * @return
     */
    public static long parseDateStr2Long(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        try {
            Date parse = sdf.parse(time);
            return parse.getTime();
        } catch (Exception e) {
            return 0;
        }
    }


}
