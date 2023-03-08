package com.cyn.demo.thread;

import com.cyn.demo.thread.bean.TestBean;

/**
 * @author chenyanan
 * Created by chenyanan on 2021/1/7
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t int:" + threadLocalDemo.getNextNum());
            System.out.println(Thread.currentThread().getName() + "\t int:" + threadLocalDemo.getTestBean("wanger"));
        }, "AAA").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t int:" + threadLocalDemo.getNextNum());
            System.out.println(Thread.currentThread().getName() + "\t int:" + threadLocalDemo.getTestBean("lisi"));

        }, "BBB").start();
    }
}
