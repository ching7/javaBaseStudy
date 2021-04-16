package com.cyn.demo.date;


import java.util.concurrent.TimeUnit;

/**
 * @author chenyanan
 * @date 2021/3/31
 * Created by chenyanan on 2021/3/31
 */
public class DateTest {
    public static void main(String[] args) {
        DateTest dateTest = new DateTest();
        dateTest.runOut();
        dateTest.timeWaitFuc();
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
