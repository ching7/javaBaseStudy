package com.cyn.demo.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * 文件描述
 *
 * @ProjectName: java-thread
 * @Package: com.cyn.threadpool
 * @Date 2020/4/23 14:17
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class FutureTaskDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(5, 10, 100, MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
        //用FutureTask包装者Callable对象
        FutureTask<String> futureC = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() {
                try {
                    System.out.println("out - Callable String ");
                    String a = "return Callable String";
                    return a;
                } catch (Exception e) {
                    e.printStackTrace();
                    return "exception";
                }
            }
        });
        // 用FutureTask包装者Runable对象
        FutureTask<String> futureF = new FutureTask<String>(new Runnable() {
            @Override
            public void run() {
                System.out.println("return Callable out");
            }
        }, futureFuc());
        //交给线程池的Execute或submit方法执行
        tpe.submit(futureC);
        tpe.execute(futureF);
        try {
            System.out.println(futureC.get());
            System.out.println(futureF.get());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            tpe.shutdown();
        }

    }
    static String futureFuc(){
        return "return Callable String";
    }
}
