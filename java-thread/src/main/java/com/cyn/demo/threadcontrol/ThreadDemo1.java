package com.cyn.demo.threadcontrol;

import static java.lang.Thread.sleep;

/**
 * 文件描述
 *
 * @ProjectName: java-threadcreate
 * @Package: com.cyn.threadcontrol
 * @Date 2020/4/20 10:55
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: 不加join的情况，实现runable实现线程
 **/
public class ThreadDemo1 implements Runnable {

    private String name;

    public ThreadDemo1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "Runnable 开始运行");
        for (int i = 0; i < 15; i++) {
            if (i == 10) {
                Thread.yield();
            }
            System.out.println("子线程" + name + "运行：" + i);
            try {
                sleep((int) Math.random() * 10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "Runnable 运行结束");
    }
}
