package com.cyn.demo.thread;

/**
 * @author chenyanan
 * Created by chenyanan on 2021/1/7
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t int:" + threadLocalDemo.getNextNum());
        }, "AAA").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t int:" + threadLocalDemo.getNextNum());
        }, "BBB").start();
    }
}
