package com.cyn.threadpool;

import com.cyn.threadcreate.ThreadDemoByCallable;

import java.util.concurrent.*;

/**
 * 文件描述
 *
 * @ProjectName: java-threadcreate
 * @Package: com.cyn.threadpool
 * @Date 2020/4/22 19:40
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class ExecutorDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 使用场景
        // 通常用于非显示的创建线程，那么什么是显示的创建线程？
        /*new Thread(new ThreadTaskByRunnable("test-Thread-default")).start();
        //那么什么是非显示创建线程呢？

        // 1. 创建执行器实例
        Executor executor = new MyExecutor();

        // 2. 调用执行器的executor方法执行任务
        executor.execute(new ThreadTaskByRunnable("test-Thread-executor"));*/


        // 3. 线程池
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                5,
                10,
                1000,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        System.out.println("线程" + r.hashCode() + "创建");
                        //线程命名
                        Thread th = new Thread(r, "threadPool自定义名称：" + r.hashCode());
                        return th;
                    }
                },
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println(r.toString() + "执行了自定义拒绝策略");

                    }
                });
        for (int i = 0; i < 13; i++) {
            /*// 1 创建ThreadDemo3对象
            Callable<String> taskThreadByCallable = new ThreadTaskByCallable("自定义 callable - ");
            // 2 使用FutureTask来包装MyCallable对象
            FutureTask<String> ft = new FutureTask<String>(taskThreadByCallable);
            // 3 FutureTask对象作为Thread对象的target创建新的线程
            Thread thread1 = new Thread(ft);
            // 4 run
            poolExecutor.execute(thread1);
            System.out.println(ft.get());*/

            // 1 创建ThreadDemo3对象
            Callable<String> taskThreadByCallable = new ThreadTaskByCallable("自定义 callable - ");
            // 2 submit
            FutureTask<String> ft = (FutureTask<String>) poolExecutor.submit(taskThreadByCallable);
            System.out.println(ft.get());

        }
        poolExecutor.shutdown();

    }
}
