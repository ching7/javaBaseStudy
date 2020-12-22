package com.cyn.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/22
 * <p>
 * 可重入锁(递归锁) ReentrantLock
 * 线程可以进入任何一个已经获取锁的，正在同步的代码块
 */
public class ReenterLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            try {
                // 两个同步代码块被同一个线程拥有
                phone.sendSms();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "AAA1").start();

        new Thread(phone, "AAA2").start();
        new Thread(phone, "AAA3").start();

    }

}

class Phone implements Runnable {
    //synchronized\reentrantlock 典型的可重入锁
    //=====synchronized
    public synchronized void sendSms() throws Exception {
        System.out.println("===" + Thread.currentThread().getId() + "\t invoked sendSms()");
        sendEmail();
    }

    public synchronized void sendEmail() throws Exception {
        System.out.println("***" + Thread.currentThread().getId() + "\t invoked sendEmail()");
    }

    //======reentrantlock
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        get();
    }

    private void get() {
        lock.lock();
        try {
            System.out.println("===" + Thread.currentThread().getId() + "\t invoked get()");
            set();
        } finally {
            lock.unlock();
        }
    }

    private void set() {
        lock.lock();
        try {
            System.out.println("***" + Thread.currentThread().getId() + "\t invoked set()");
        } finally {
            lock.unlock();
        }
    }
}
