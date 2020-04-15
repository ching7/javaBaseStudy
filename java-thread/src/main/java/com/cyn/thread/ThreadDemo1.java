package com.cyn.thread;

/**
 * 文件描述
 *
 * @ProjectName: java-thread
 * @Package: com.cyn.thread
 * @Date 2020/4/15 14:42
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description:
 * 继承Thread类，重写该类的run()方法
 **/
public class ThreadDemo1 extends Thread {
    private String name;

    public ThreadDemo1(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + "运行  ：" + i);
        }
    }
}
