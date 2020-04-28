package com.cyn.threadcreate;

/**
 * 文件描述
 *
 * @ProjectName: java-threadcreate
 * @Package: com.cyn.threadcreate
 * @Date 2020/4/15 14:42
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description:
 * 继承Thread类，重写该类的run()方法
 **/
public class ThreadDemoByThread extends Thread {
    private String name;

    public ThreadDemoByThread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            int i = 1;
            System.out.println(name + "运行  ：" + i);
            i++;
        }
    }
}
