package com.cyn.demo;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-11-02
 */
public class FutureTaskDemo {
    public String mainDemo() throws ExecutionException, InterruptedException {
        try {
            System.out.println("111");
            FutureTask futureTask = new FutureTask(() -> {
                // 线程暂停3s
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("333");
                return null;
            });
            futureTask.run();
            System.out.println("222");
            return "1122";
        } catch (Exception e) {
        }
        return "444";
    }

    @Test
    public void test() throws ExecutionException, InterruptedException {
        mainDemo();
    }
}
