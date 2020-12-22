package com.cyn.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/18
 * 自旋锁
 * <p>
 * 通过while循环，不断重试，实际没加锁
 */
public class SpinLockDemo {
    //原子引用线程
    AtomicReference<String> atomicReference = new AtomicReference<>();
    String init = "init";

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(() -> {
            spinLockDemo.myLock();
            // 线程暂停3s
            try {
                TimeUnit.SECONDS.sleep(3);
                spinLockDemo.unLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AAA").start();

        // 线程暂停3s
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            spinLockDemo.myLock();
            spinLockDemo.unLock();
        }, "BBB").start();
    }

    public void myLock() {
        System.out.println("===" + Thread.currentThread().getName() + "\t come in myLock");
        while (!atomicReference.compareAndSet(null, init)) {
        }
    }

    public void unLock() {
        // 自旋跳出，解锁对象
        atomicReference.compareAndSet(init, null);
        System.out.println("===" + Thread.currentThread().getName() + "\t come in unLock");
    }
}
