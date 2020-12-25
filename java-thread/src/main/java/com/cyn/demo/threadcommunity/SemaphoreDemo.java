package com.cyn.demo.threadcommunity;

import java.util.concurrent.Semaphore;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/25
 * <p>
 * 　Semaphore也是一个线程同步的辅助类，可以维护当前访问自身的线程个数，并提供了同步机制。使用Semaphore可以控制同时访问资源的线程个数，例如，实现一个文件允许的并发访问数。
 * <p>
 * Semaphore的主要方法摘要：
 * <p>
 * 　　void acquire():从此信号量获取一个许可，在提供一个许可前一直将线程阻塞，否则线程被中断。
 * <p>
 * 　　void release():释放一个许可，将其返回给信号量。
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    // 确认是否有信号量，没有回阻塞当前线程，等待信号量
                    semaphore.acquire();
                    // 模拟线程延时
                    Thread.sleep(3000);
                    System.out.println("===" + Thread.currentThread().getName() + "\t 抢到线程");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 释放信号量
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }

    }
}
