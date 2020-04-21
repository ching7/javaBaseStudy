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
        /*pool = new ThreadPoolExecutor(2, 4, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        System.out.println("线程"+r.hashCode()+"创建");
                        //线程命名
                        Thread th = new Thread(r,"threadPool"+r.hashCode());
                        return th;
                    }
                }, new ThreadPoolExecutor.CallerRunsPolicy());*/
        //7 ThreadPoolExecutor扩展
        // 主要是围绕beforeExecute()、afterExecute()和terminated()三个接口实现的
        pool = new ThreadPoolExecutor(2, 4, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        System.out.println("线程" + r.hashCode() + "创建");
                        //线程命名
                        Thread th = new Thread(r, "threadPool" + r.hashCode());
                        return th;
                    }
                }, new ThreadPoolExecutor.CallerRunsPolicy()) {
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("准备执行：" + ((ThreadTask) r).getTaskName());
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("执行完毕：" + ((ThreadTask) r).getTaskName());
            }

            @Override
            protected void terminated() {
                System.out.println("线程池退出");
            }
        };
        // 8 线程池数量
        // 线程吃线程数量的设置没有一个明确的指标，根据实际情况，只要不是设置的偏大和偏小都问题不大，结合下面这个公式即可
        /**
         * Nthreads=CPU数量
         * Ucpu=目标CPU的使用率，0<=Ucpu<=1
         * W/C=任务等待时间与任务计算时间的比率
         */
        // Nthreads = Ncpu*Ucpu*(1+W/C)
        for (int i = 0; i < 13; i++) {
            pool.execute(new ThreadTask("Task" + i));
        }
        pool.shutdown();
    }
}
