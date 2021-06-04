package com.cyn.demo.date;


import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author chenyanan
 * @date 2021/3/31
 * Created by chenyanan on 2021/3/31
 */
public class DateTest {
    public static void main(String[] args) {
        //System.out.println(nowDateTime());
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        AtomicLong offset = new AtomicLong(1000);
//        long offset2 = 1000;
//        for (Integer integer : integers) {
//            System.out.println(integer + " %%%% " + nowDateTimeAdd(offset2));
//            offset2 = offset2 + 1000;
//        }
        integers.forEach(integer -> {
            System.out.println(integer + " %%%% " + nowDateTimeAdd(offset.get()));
            offset.getAndAdd(1000);
        });
/*        DateTest dateTest = new DateTest();
        dateTest.runOut();
        dateTest.timeWaitFuc();*/
    }

    public static Date nowDateTimeAdd(long addTime) {
        return new Timestamp(System.currentTimeMillis() + addTime);
    }

    public static Date nowDateTime() {
        return new Timestamp(System.currentTimeMillis());
    }

    public void runOut() {
        int i = 0;
        // 线程暂停3s
        try {
            TimeUnit.SECONDS.sleep(3);
            runOut2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i++);
    }

    public void runOut2() {
        int i = 0;
        // 线程暂停3s
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i++);
    }

    public void timeWaitFuc() {
        while (true) {
            // 线程暂停3s
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("time wait");
        }

    }
}
