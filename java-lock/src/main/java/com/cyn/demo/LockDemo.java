package com.cyn.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/22
 */
public class LockDemo {
    volatile static int n = 0;

    public static void add() {
        n++;
        System.out.println("===");
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock(true);
        if (lock.tryLock()) {
            try {
                add();
            } catch (Exception ignored) {

            } finally {
                lock.unlock();
            }

        }
    }
}
