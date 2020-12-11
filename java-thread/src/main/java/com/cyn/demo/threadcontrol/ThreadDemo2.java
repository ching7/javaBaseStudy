package com.cyn.demo.threadcontrol;

/**
 * 文件描述
 *
 * @ProjectName: java-threadcreate
 * @Package: com.cyn.threadcontrol
 * @Date 2020/4/20 11:18
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description:  不加join的情况，继承thread实现线程
 **/
public class ThreadDemo2 extends Thread {

    private String name;

    public ThreadDemo2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "Thread 开始运行");
        try {
            while (!isInterrupted()){
                for (int i = 0; i < 15; i++) {
                    if (i == 11) {
                        Thread.yield();
                    }
                    System.out.println("子线程" + name + "运行：" + i);
//            try {
//                sleep((int) Math.random() * 10);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
                }
                System.out.println(Thread.currentThread().getName() + "Thread 运行结束");
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
