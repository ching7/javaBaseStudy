package com.cyn.demo.threadcontrol;


/**
 * 文件描述
 *
 * @ProjectName: java-threadcreate
 * @Package: com.cyn.threadcontrol
 * @Date 2020/4/20 10:55
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: 线程加入——join()
 **/
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        // 1 不加join的线程运行情况,使用实现runable接口方式
        System.out.println(Thread.currentThread().getName() + "主线程开始运行");
        /*ThreadDemoByThread threadA = new ThreadDemoByThread("Aa");
        ThreadDemoByThread threadB = new ThreadDemoByThread("Ba");
        Thread threadAa = new Thread(threadA);
        Thread threadBa = new Thread(threadB);

        threadAa.start();
        threadBa.start();*/

        ThreadDemo2 threadAt = new ThreadDemo2("At");
        ThreadDemo2 threadBt = new ThreadDemo2("bt");
        threadAt.start();
        threadBt.start();
        Thread.sleep(1);
        threadAt.interrupt();
        threadBt.interrupt();
        System.out.println(Thread.currentThread().getName() + "主线程运行结束");

    }
}
