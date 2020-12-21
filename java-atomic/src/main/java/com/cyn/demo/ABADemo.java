package com.cyn.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/21、
 * <p>
 * ABA问题的解决，原子引用引入冗余解决
 */
public class ABADemo {
    static AtomicReference<Integer> atomicReference = new AtomicReference(100);
    /**
     * 引入原子引用+时间戳
     */
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {
        new Thread(() -> {
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);
        }, "t1").start();
        new Thread(() -> {
            // 线程暂停1s,保证t1先执行，完成ABA操作
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("===" + Thread.currentThread().getName() + "\t " + atomicReference.compareAndSet(100, 2020) + "\t "
                    + atomicReference.get().toString());
        }, "t2").start();

        System.out.println("===ABA解决方法");
        // 两线程同时暂停，保证起始点一一致
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println("===" + Thread.currentThread().getName() + "\t 第一次版本：" + stamp);
            // 线程暂停1s
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100,
                    101, atomicStampedReference.getStamp(),
                    atomicStampedReference.getStamp() + 1);
            System.out.println("===" + Thread.currentThread().getName() + "\t 第二次版本："
                    + atomicStampedReference.getStamp());

            atomicStampedReference.compareAndSet(101,
                    100, atomicStampedReference.getStamp(),
                    atomicStampedReference.getStamp() + 1);
            System.out.println("===" + Thread.currentThread().getName() + "\t 第三次版本："
                    + atomicStampedReference.getStamp());

        }, "t3").start();

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println("===" + Thread.currentThread().getName() + "\t 第一次版本：" + stamp);
            // 线程暂停3s
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //重新取新版时间戳可以修改成功
            /*boolean res = atomicStampedReference.compareAndSet(100,
                    2020, atomicStampedReference.getStamp(),
                    atomicStampedReference.getStamp() + 1);*/

            //旧的时间戳导致更新失败
            boolean res = atomicStampedReference.compareAndSet(100,
                    2020, stamp,
                    stamp + 1);
            System.out.println("===" + Thread.currentThread().getName()
                    + "\t 修改结果：" + res + "\t 最新版本" + atomicStampedReference.getStamp()
                    + "\t 最新值：" + atomicStampedReference.getReference());

        }, "t4").start();
    }
}
