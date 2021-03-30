package com.cyn.demo.threadcreate;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author chenyanan
 * @date 2021/3/30
 * Created by chenyanan on 2021/3/30
 */
public class ThreadByCallableMain {
    public static void main(String[] args) {
        // 方法3
        // 1 创建ThreadDemo3对象
        Callable<Integer> myCallable = new ThreadDemoByCallable();
        /*Callable<String> myCallable = () -> {
            System.out.println("自定义lambda:" + Thread.currentThread().getName());
            return "自定义lambda";
        };*/
        // 2 使用FutureTask来包装MyCallable对象
        FutureTask<Integer> ft = new FutureTask<Integer>(myCallable);
        //FutureTask<String> ft = new FutureTask<String>(myCallable);

        // 3 FutureTask对象作为Thread对象的target创建新的线程
        Thread thread1 = new Thread(ft);
        long startTime = System.currentTimeMillis();
        ThreadDemoByThread testT = new ThreadDemoByThread("测试线程");
        testT.start();
        // 4 线程进入到就绪状态
        thread1.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "主线程在执行任务");
    }
}
