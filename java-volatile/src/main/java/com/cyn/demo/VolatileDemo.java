package com.cyn.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/17
 *
 * <p>
 * 即当前线程的修改可以被其他线程知晓
 */
public class VolatileDemo {
    public static void main(String[] args) {
        // seeOkByVolatile();
        notAtomic();
    }

    /**
     * 1.验证volatile的可见性
     * 1.1 volatile修饰值，会在当前线程结束时，刷新当前线程内存的值到主内存
     * 1.2 修饰的变量在每次是用之前都从主内存刷新
     */
    public static void seeOkByVolatile() {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in ");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
        }, "AAA").start();


        new Thread(() -> {
            while (myData.number == 0) {
                // main线程等待,直到number!=0
            }
            System.out.println(Thread.currentThread().getName() + "\t mission over");
        }, "BBB").start();
    }

    /**
     * 2.验证volatile不保证原子性
     * 不可分割，完整。即某个线程正在做某个具体业务时，中间不可以被加塞或者分割，需要整体完成，要么同时成功，要么同时失败
     * 如何解决呢？  
     * 2.1 使用 synchronize --
     * 2.2 使用 AtomicInteger
     */
    public static void notAtomic() {
        MyData myData = new MyData();

        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myData.addToPlus();
                    myData.addAtomic();
                }
            }, String.valueOf(i)).start();
        }
        // main线程等待
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\n"
                + "number plus over ,number:"
                + myData.number + "\n"
                + ",atomicInteger:" + myData.atomicInteger);
    }
}

class MyData {
    volatile int number = 0;

    public void addTo60() {
        this.number = 60;
    }

    public void addToPlus() {
        this.number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    public void addAtomic() {
        atomicInteger.getAndIncrement();
    }
}
