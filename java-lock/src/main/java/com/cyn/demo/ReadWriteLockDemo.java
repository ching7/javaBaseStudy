package com.cyn.demo;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/23
 * <p>
 * 读写锁
 * <p>
 * 多个线程同时读一个资源类，没有任何问题，为了满足并发量，读取共享资源可以同时进行
 * 但是
 * 如果有一个线程想写共享资源类，就不应该再有其他线程可以对该资源类进行读或者写
 * 即：
 * 读-读 共存
 * 读-写 不共存
 * 写—写 不共存
 * 写操作：原子独占，不可中断
 * <p>
 * A\B原则
 * before使用该技术前
 * after使用技术后
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for (int i = 0; i < 6; i++) {
            final int finalI = i;
            new Thread(() -> {
                myCache.put(finalI + "", finalI + "");
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 6; i++) {
            final int finalI = i;
            new Thread(() -> {
                myCache.get(finalI + "");
            }, String.valueOf(i)).start();
        }
    }
}

class MyCache {
    private volatile Map<String, Object> map = new Hashtable<>();
    // private Lock lock = new ReentrantLock();
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    /**
     * 模拟写操作
     *
     * @param key
     * @param value
     */
    public void put(String key, Object value) {
        // 写锁
        rwLock.writeLock().lock();
        try {
            System.out.println("===" + Thread.currentThread().getName() + "\t 正在写入" + key);
            // 线程暂停3s
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwLock.writeLock().unlock();
        }
        map.put(key, value);
        System.out.println("===" + Thread.currentThread().getName() + "\t 写入完成" + map);
    }

    /**
     * 模拟读操作
     *
     * @param key
     */
    public void get(String key) {
        rwLock.readLock().lock();
        System.out.println("===" + Thread.currentThread().getName() + "\t 正在读取" + key);
        // 线程暂停3s
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwLock.readLock().unlock();
        }
        Object res = map.get(key);
        System.out.println("===" + Thread.currentThread().getName() + "\t 读取完成" + res);
    }
}
