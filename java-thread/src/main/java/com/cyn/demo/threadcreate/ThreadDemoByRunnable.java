package com.cyn.demo.threadcreate;

/**
 * 文件描述
 *
 * @ProjectName: java-threadcreate
 * @Package: com.cyn.threadcreate
 * @Date 2020/4/15 15:17
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: 实现java.lang.Runnable接口
 * <p>
 * 具体做法：实现Runnable接口，并重写该接口的run()方法，该run()方法同样是线程执行体，
 * 创建Runnable实现类的实例，并以此实例作为Thread类的target来创建Thread对象，该Thread对象才是真正的线程对象。
 **/
public class ThreadDemoByRunnable implements Runnable {
    public volatile boolean running = true;

    private String name;

    public ThreadDemoByRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        // 1 判断线程中断

//        while (!Thread.currentThread().isInterrupted()) {
//            int i = 1;
//            System.out.println(name + "运行  ：" + i);
//            i++;
//        }
        // 2 判断线程中断
        int n=0;
        while (running) {
            n++;
            System.out.println( "任务名："+this.name + " " + n+ " hello!"+ "使用线程："+Thread.currentThread().getName());
        }
        System.out.println(this.name + " end");
    }
}
