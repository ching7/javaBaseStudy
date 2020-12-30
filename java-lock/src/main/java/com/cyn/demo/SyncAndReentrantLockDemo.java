package com.cyn.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/29
 * <p>
 * 问：synchroized和lock的区别，新的lock有什么好处
 * 1.原始构成
 * <p>
 * synchronized是关键字属于JVM层面。
 * monitorenter（底层通过monitor对象来完成，其实wait/notify等方法也依赖于monitor对象
 * 只有在同步块或方法中才能调用wait/notify等方法）
 * monitorexit(2次调用，保证异常退出)-保证不会出现死锁
 * <p>
 * lock是具体类（java.util.concurrent.locks.lock）是api层面的锁
 * 2.使用方法
 * synchronized 不需要手动释放锁，当synchronized代码执行完成后系统会自动让线程释放对锁的占用
 * <p>
 * Reentrantlock 需要用户手动释放锁。不主动释放可能会死锁需要使用lock()和unlock(),配合try\finally使用
 * 3.等待是否可以中断
 * synchronized不可中断，除非抛出异常或正常执行结束
 * <p>
 * ReentrantLock可中断
 * 设置超时方法tryLock(long timeout, TimeUnit unit)
 * lockInterruptibly()放代码块中，调用interrupt()方法可中断
 * 4.加锁是否公平
 * synchronized非公平锁
 * <p>
 * ReentrantLock两者都可，默认是非公平锁，构造方法可以传入boolean值，true为公平锁，false为非公平锁
 * 5.锁绑定多个条件condition
 * synchronized没有
 * <p>
 *  ReentrantLock用来实现分组唤醒需要唤醒的线程，可以精确唤醒，而不是像synchronized随即唤醒一个或者全部唤醒
 * <p>
 * 练习题:
 * 多线程之间按照顺序调用，实现A->B->C三个线程启动
 * AA打印5次，BB打印10次，CC打印15次
 * 。。。依次来10轮
 */
public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
        // 查看字节码，查看区别
 /*       synchronized (new Object()) {

        }
        new ReentrantLock();*/

        ShareResource shareResource = new ShareResource();
        new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                shareResource.print5();
            }
        }, "AAA").start();
        new Thread(() -> {
            for (int i = 0; i < 11; i++) {
                shareResource.print10();
            }
        }, "BBB").start();
        new Thread(() -> {
            for (int i = 0; i < 16; i++) {
                shareResource.print15();
            }
        }, "CCC").start();
    }
}

class ShareResource {
    // 线程间标志位
    private int number = 1;

    private Lock lock = new ReentrantLock();

    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            // 1 判断
            while (number != 1) {
                c1.await();
            }
            // 2 干活
            for (int i = 0; i < 6; i++) {
                System.out.println("===" + Thread.currentThread().getName() + "\t " + i);
            }
            // 3 通知
            number = 2;
            // 指定线程通知
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            // 1 判断
            while (number != 2) {
                c2.await();
            }
            // 2 干活
            for (int i = 0; i < 11; i++) {
                System.out.println("===" + Thread.currentThread().getName() + "\t " + i);
            }
            // 3 通知
            number = 3;
            // 指定线程通知
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            // 1 判断
            while (number != 3) {
                c3.await();
            }
            // 2 干活
            for (int i = 0; i < 16; i++) {
                System.out.println("===" + Thread.currentThread().getName() + "\t " + i);
            }
            // 3 通知
            number = 1;
            // 指定线程通知
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
