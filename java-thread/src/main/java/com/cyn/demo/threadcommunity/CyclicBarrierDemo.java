package com.cyn.demo.threadcommunity;

import java.util.concurrent.CyclicBarrier;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/24
 * <p>
 * 字面意思是可循环使用的屏障。它要做的事情是
 * 让一组线程到达一个屏障时被阻塞，直到最后一个线程到达屏障时
 * 屏障才会打开，所有被屏障拦截的线程才会继续干活，线程进入屏障通过CyclicBarrier的await()方法
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("神龙");
        });
        for (int i = 1; i <= 7; i++) {
            final int finali = i;
            new Thread(() -> {
                System.out.println("第：" + finali + " 龙珠");
                try {
                    cyclicBarrier.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }

    }
}
