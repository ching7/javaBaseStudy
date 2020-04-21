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
        //pool = new ThreadPoolExecutor(1, 2, 1000,
        // TimeUnit.MILLISECONDS,
        // new SynchronousQueue<Runnable>(),
        // Executors.defaultThreadFactory(),
        // new ThreadPoolExecutor.AbortPolicy());

        // 2 有界的任务队列
        //pool = new ThreadPoolExecutor(1, 2, 1000,
        // TimeUnit.MILLISECONDS,
        // new ArrayBlockingQueue<Runnable>(10),
        // Executors.defaultThreadFactory(),
        // new ThreadPoolExecutor.AbortPolicy());

        // 3 无界任务队列
        //pool = new ThreadPoolExecutor(1, 2, 1000,
        // TimeUnit.MILLISECONDS,
        // new LinkedBlockingQueue<Runnable>(),
        // Executors.defaultThreadFactory(),
        // new ThreadPoolExecutor.AbortPolicy());

        // 4 优先任务队列
        /*pool = new ThreadPoolExecutor(1, 2, 1000,
         TimeUnit.MILLISECONDS,
         new PriorityBlockingQueue<Runnable>(),
         Executors.defaultThreadFactory(),
         new ThreadPoolExecutor.AbortPolicy());*/

        // 5 自定义拒绝策略
        /*pool = new ThreadPoolExecutor(1, 2, 1000,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5),
                Executors.defaultThreadFactory(),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println(r.toString() + "执行了自定义拒绝策略");

                    }
                });*/
        //6 自定义线程工厂
        pool = new ThreadPoolExecutor(2, 4, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        System.out.println("线程"+r.hashCode()+"创建");
                        //线程命名
                        Thread th = new Thread(r,"threadPool"+r.hashCode());
                        return th;
                    }
                }, new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 13; i++) {
            pool.execute(new ThreadTaskFirst(i));
        }
    }
}
