package com.cyn.threadsafe;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 文件描述
 *
 * @ProjectName: java-thread
 * @Package: com.cyn.threadsafe
 * @Date 2020/4/30 10:06
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class ReentrantLockClass {
    private final Lock lock = new ReentrantLock();
    private int count;

    public int add(int n) throws InterruptedException {
        //return count += n;

//        lock.lock();
//        try {
//           return count += n;
//        } finally {
//            lock.unlock();
//        }
        if (lock.tryLock(5, TimeUnit.MILLISECONDS)) {
            try {
                Thread.sleep(10);
                return count += n;
            } finally {
                lock.unlock();
            }
        }else{
            System.out.println(Thread.currentThread().getName()+"获取锁失败");
            return 0;
        }
    }
}
