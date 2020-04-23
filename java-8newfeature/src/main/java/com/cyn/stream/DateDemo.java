package com.cyn.stream;

import java.time.*;
import java.util.concurrent.TimeUnit;

/**
 * 文件描述
 *
 * @ProjectName: java-8newfeature
 * @Package: com.cyn.stream
 * @Date 2020/4/23 19:55
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description:
 * Java 8通过发布新的Date-Time API (JSR 310)来进一步加强对日期与时间的处理。
 *
 * 在旧版的 Java 中，日期时间 API 存在诸多问题，其中有：
 *
 * 非线程安全 − java.util.Date 是非线程安全的，所有的日期类都是可变的，这是Java日期类最大的问题之一。
 *
 * 设计很差 − Java的日期/时间类的定义并不一致，在java.util和java.sql的包中都有日期类，此外用于格式化和解析的类在java.text包中定义。java.util.Date同时包含日期和时间，而java.sql.Date仅包含日期，将其纳入java.sql包并不合理。另外这两个类都有相同的名字，这本身就是一个非常糟糕的设计。
 *
 * 时区处理麻烦 − 日期类并不提供国际化，没有时区支持，因此Java引入了java.util.Calendar和java.util.TimeZone类，但他们同样存在上述所有的问题。
 *
 * Java 8 在 java.time 包下提供了很多新的 API。以下为两个比较重要的 API：
 *
 * Local(本地) − 简化了日期时间的处理，没有时区的问题。
 *
 * Zoned(时区) − 通过制定的时区处理日期时间。
 *
 * 新的java.time包涵盖了所有处理日期，时间，日期/时间，时区，时刻（instants），过程（during）与时钟（clock）的操作。
 **/
public class DateDemo {
    public static void main(String[] args) throws InterruptedException {
        //==日期/时间
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("当前时间: " + currentTime);
        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date1: " + date1);

        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();

        System.out.println("月: " + month +", 日: " + day +", 秒: " + seconds);
        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);

        // 12 december 2014
        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date3: " + date3);

        // 22 小时 15 分钟
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);

        // 解析字符串
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);


        //==instants
        Instant start = Instant.now();
        System.out.println("now1:"+start);
        //注意：通过这种方式获取的时间戳与北京时间相差8个时区，需要修正为北京时间，通过查看源代码发现Instant.now()使用等是UTC时间Clock.systemUTC().instant()。LocalDate、LocalDateTime 的now()方法使用的是系统默认时区 不存在Instant.now()的时间问题。
        //解决方法 增加8个小时
        Thread.sleep(1000);
        Instant now2 = Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8));
        System.out.println("now2:"+now2);
        System.out.println("秒数:"+now2.getEpochSecond());
        System.out.println("毫秒数:"+now2.toEpochMilli());
        Instant end = Instant.now();

        //==during
        System.out.println("耗时：" + Duration.between(start, end).toMillis() + "ms");
    }
}
