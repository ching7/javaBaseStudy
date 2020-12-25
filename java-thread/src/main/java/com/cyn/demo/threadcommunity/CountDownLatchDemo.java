package com.cyn.demo.threadcommunity;

import java.util.concurrent.CountDownLatch;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/23
 * <p>
 * 让一些线程阻塞，直到另一些线程完成一系列操作后才被唤醒
 * <p>
 * CountDownLatch主要有两个方法，当一个或多个线程调用await方法时
 * 调用线程会被阻塞。其它线程调用countDown方法会将计数器减一（调用countDown方法的线程不会阻塞）
 * 当计数器的值变为0时，因调用await方法被阻塞的线程会被唤醒，继续执行
 * <p>
 * 初始值10线程，每做完一个线程，线程总数-1,最后一个完成，主线程执行
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
