package com.cyn.threadpool;

import java.util.concurrent.*;

/**
 * 文件描述
 *
 * @ProjectName: java-thread
 * @Package: com.cyn.threadpool
 * @Date 2020/4/20 19:02
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class ThreadPool {
    private static ExecutorService pool;

    public static void main(String[] args) {
        // 1 直接提交队列
        //maximumPoolSize设置为2 ，拒绝策略为AbortPolic策略，直接抛出异常
        //pool = new ThreadPoolExecutor(1, 2, 1000, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        // 2 有界的任务队列
        pool = new ThreadPoolExecutor(1, 2, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 20; i++) {
            pool.execute(() ->
                    System.out.println(Thread.currentThread().getName()));
        }
    }
}
