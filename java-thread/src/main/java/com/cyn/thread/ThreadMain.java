package com.cyn.thread;

import java.util.concurrent.*;

/**
 * 文件描述
 *
 * @ProjectName: java-thread
 * @Package: com.cyn.thread
 * @Date 2020/4/15 15:13
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class ThreadMain {
    public static void main(String[] args) {
        // 方法1
        /*ThreadDemo1 threadDemo1 = new ThreadDemo1("demo1");
        ThreadDemo1 threadDemo2 = new ThreadDemo1("demo2");

        // 注意run 和start 的区别
        threadDemo1.run();
        threadDemo2.run();
        System.out.println("========");
        threadDemo1.start();
        threadDemo2.start();
        System.out.println("========");*/

        // 方法2
        /*// 创建一个Runnable实现类的对象
        ThreadDemo2 myRunnable = new ThreadDemo2("A");
        // 将myRunnable作为Thread target创建新的线程

        Thread thread1 = new Thread(myRunnable);
        ThreadDemo2 myRunnable1 = new ThreadDemo2("B");
        // 调用start()方法使得线程进入就绪状态
        Thread thread2 = new Thread(myRunnable1);
        thread1.start();
        thread2.start();*/

        // 方法3
        // 创建ThreadDemo3对象
        Callable<Integer> myCallable = new ThreadDemo3();
        //使用FutureTask来包装MyCallable对象
        FutureTask<Integer> ft = new FutureTask<Integer>(myCallable);
        //FutureTask对象作为Thread对象的target创建新的线程
        Thread thread = new Thread(ft);
        long startTime = System.currentTimeMillis();

        //线程进入到就绪状态
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            // fixme:FutureTask 的介绍补充
            //取得新创建的线程中的call()方法返回的结果
            /*int sum = 0;
            if (ft.isDone()){
                sum = ft.get();
            }*/
            int sum = ft.get();
            System.out.println("task运行结果,sum = " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("总共用时" + (System.currentTimeMillis() - startTime) + "ms");

        System.out.println("所有任务执行完毕");

    }
}
