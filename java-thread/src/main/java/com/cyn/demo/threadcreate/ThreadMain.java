package com.cyn.demo.threadcreate;

import java.util.concurrent.*;

/**
 * 文件描述
 *
 * @ProjectName: java-threadcreate
 * @Package: com.cyn.threadcreate
 * @Date 2020/4/15 15:13
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class ThreadMain {
    public static void main(String[] args) {
        // 方法1
        /*ThreadDemoByThread threadDemo1 = new ThreadDemoByThread("demo1");
        ThreadDemoByThread threadDemo2 = new ThreadDemoByThread("demo2");

        // 注意run 和start 的区别
        threadDemo1.run();
        threadDemo2.run();
        System.out.println("========");
        threadDemo1.start();
        threadDemo2.start();
        System.out.println("========");*/

        // 方法2
        /*// 创建一个Runnable实现类的对象
        ThreadDemoByRunnable myRunnable = new ThreadDemoByRunnable("A");
        // 将myRunnable作为Thread target创建新的线程

        Thread thread1 = new Thread(myRunnable);
        ThreadDemoByRunnable myRunnable1 = new ThreadDemoByRunnable("B");
        // 调用start()方法使得线程进入就绪状态
        Thread thread2 = new Thread(myRunnable1);
        thread1.start();
        thread2.start();*/

        // 方法3
        // 1 创建ThreadDemo3对象
        Callable<Integer> myCallable = new ThreadDemoByCallable();
        // 2 使用FutureTask来包装MyCallable对象
        FutureTask<Integer> ft = new FutureTask<Integer>(myCallable);
        // 3 FutureTask对象作为Thread对象的target创建新的线程
        Thread thread1 = new Thread(ft);
        long startTime = System.currentTimeMillis();

        // 4 线程进入到就绪状态
        thread1.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println("主线程在执行任务");

        try {
            // fixme:FutureTask 的介绍补充
            //取得新创建的线程中的call()方法返回的结果
            int sum = 0;
            // isDone不会阻塞当前线程
            // 如果主线程花费时间大于子线程，这里判断为true，可以成功获取值，否则此处为空
            /*if (ft.isDone()){
                sum = ft.get();
            }*/
            // get() 会阻塞Blocked当前线程，直到子线程有返回值时，才会Runnable
            /*int sum = ft.get();*/
            System.out.println("主线程获取task运行结果,sum = " + sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("总共用时" + (System.currentTimeMillis() - startTime) + "ms");

        System.out.println("所有任务执行完毕");

    }
}
