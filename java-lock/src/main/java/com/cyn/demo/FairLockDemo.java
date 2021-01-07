package com.cyn.demo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/22
 * <p>
 * 公平/非公平锁FairSync
 * 公平锁：多个线程按照申请锁的顺序来获取锁
 * 非公平锁：多个线程获取锁的顺序并不是按照申请锁的顺序，有可能后申请的线程比先申请的线程
 * 优先获取锁，可能会出现优先级反转，或者是饥饿现象（可能存在线程一直获取不到锁）
 */
public class FairLockDemo {
    /**
     * true 表示 ReentrantLock 的公平锁
     * 顺序获得锁
     */
    private final ReentrantLock failLock = new ReentrantLock(true);
    /**
     * true 表示 ReentrantLock 的非公平锁
     * 非顺序获得锁，某一时间段可能一直被一个线程持有锁
     */
    private final ReentrantLock unFailLock = new ReentrantLock(false);

    public static void main(String[] args) {
        fairLockTest();
        //unFailTest();
    }

    public static void unFailTest() {
        FairLockDemo fairLockDemo = new FairLockDemo();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println("===" + Thread.currentThread().getName() + "\t 启动");
                fairLockDemo.testUnFail();
            }, String.valueOf(i)).start();
        }
    }

    public static void fairLockTest() {
        FairLockDemo fairLockDemo = new FairLockDemo();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println("===" + Thread.currentThread().getName() + "\t 启动");
                fairLockDemo.testFail();
            }, String.valueOf(i)).start();
        }
    }

    public void testFail() {
        while (true) {
            failLock.lock();
            try {
                System.out.println("===" + Thread.currentThread().getName() + "\t 获得锁");
            } finally {
                failLock.unlock();
            }
        }

    }

    public void testUnFail() {
        while (true) {
            unFailLock.lock();
            try {
                System.out.println("===" + Thread.currentThread().getName() + "\t 获得锁");
            } finally {
                unFailLock.unlock();
            }
        }

    }
}
