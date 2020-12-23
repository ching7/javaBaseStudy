package com.cyn.demo.threadcommunity;

import java.util.concurrent.CountDownLatch;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/23
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10;
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                System.out.println("===" + Thread.currentThread().getName() + "\t leave");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        // 确保前置所有线程执行结束，再进行主线程
        System.out.println("===" + Thread.currentThread().getName() + "\t main wait");
        countDownLatch.await();
        System.out.println("===" + Thread.currentThread().getName() + "\t main leave");
    }
}
