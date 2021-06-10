package com.cyn.demo.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 文件描述
 *
 * @ProjectName: java-threadcreate
 * @Package: com.cyn.threadpool
 * @Date 2020/4/22 19:32
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: jdk提供的默认线程池
 * Executor接口是Executor的父接口，基于生产者--消费者模式，提交任务的操作相当于生产者，执行任务的线程则相当于消费者，如果要在程序中实现一个生产者--消费者的设计，那么最简单的方式通常是使用Executor。
 * <p>
 * ExecutorService接口是对Executor接口的扩展，提供了对生命周期的支持，以及统计信息收集、应用程序管理机制和性能监视等机制。
 * <p>
 * 常用的使用方法是调用Executors中的静态方法来创建一个连接池。
 **/
public class JdkDefaultThreadPool {
    public static void main(String[] args) throws InterruptedException {
        // 1 newFixedThreadPool
        /*ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 4; i++){
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    CountDownLatch countDownLatch = new CountDownLatch(1); //计数器，用于阻塞线程
                    System.out.println(Thread.currentThread().getName() + "正在执行");
                    try {
                        // countDownLatch.countDown();

                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.execute(runnable);
        }
        executorService.shutdown();*/

        // 2 newCachedThreadPool
        /*ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 4; i++){
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    CountDownLatch countDownLatch = new CountDownLatch(1); //计数器，用于阻塞线程
                    System.out.println(Thread.currentThread().getName() + "正在执行");
                    try {
                        countDownLatch.countDown();
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            executor.execute(runnable);
        }
        executor.shutdown();*/

        // 3 newSingleThreadExecutor
        /*ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 4; i++) {
            final int index = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在执行工作任务--- >" + index);
                }
            };
            executor.execute(runnable);
        }
        executor.shutdown();*/
        // 4 ScheduledExecutorService
        /*ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 3; i++){
            final int index = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "延时1s后，每5s执行一次工作任务--- >" + index);
                }
            };
            executor.scheduleAtFixedRate(runnable,1,5,TimeUnit.SECONDS);
        }
        // executor.shutdown();*/

        // 5 线程池退出
        // 退出方法1：CountDownLatch定时器
        /*List<Integer> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tasks.add(i);
        }

        ExecutorService pool = Executors.newFixedThreadPool(20);

        CountDownLatch latch = new CountDownLatch(tasks.size());

        for (Integer task : tasks) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        System.out.println("task " + task + " end");
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        latch.countDown();
                    }
                }
            });
        }
        // 阻塞等待所有线程结束
        latch.await();
        pool.shutdown();*/
        // 退出方法2：ExecutorService对象的shutdown()和shutdownNow()
        List<Integer> tasks = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            tasks.add(i);
        }

        ExecutorService pool = Executors.newFixedThreadPool(20,new ThreadFactoryBuilder().setNameFormat("JdkDefaultThreadPool-%d").build());

        for (Integer task : tasks) {
            pool.submit(() -> {
                try {
                    Thread.sleep(500);
                    System.out.println(Thread.currentThread().getName() +": task " + task + " end");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

        }
        // List<Runnable> runnableList = pool.shutdownNow();
        pool.shutdown();
    }
}
