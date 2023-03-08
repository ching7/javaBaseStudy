package com.cyn.concurrent.lockandcondition;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 大部分情况下我们使用非公平锁，因为其性能比公平锁好很多。
 * 但是公平锁能够避免线程饥饿，某些情况下也很有用。
 * @Author: ynchen9
 * @CreateTime: 2022-02-16
 */
public class ReentrantLockTest {
    // 公平锁：当锁可用时,在锁上等待时间最长的线程将获得锁的使用
    // static Lock lock = new ReentrantLock(true);
    // 非公平锁：随机分配这种使用权
    static Lock lock = new ReentrantLock(false);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new ThreadDemo(i)).start();
        }
    }

    static class ThreadDemo implements Runnable {
        Integer id;

        public ThreadDemo(Integer id) {
            this.id = id;
        }

        @Override
        public void run() {
            // 线程暂停3s
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 2; i++) {
                lock.lock();
                System.out.println("get thread id:" + id);
                lock.unlock();
            }
        }
    }
}
