package com.cyn.completablefuture;

import java.util.concurrent.*;

/**
 * 文件描述
 *
 * @ProjectName: java-8newfeature
 * @Package: com.cyn.completablefuture
 * @Date 2020/4/24 11:23
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1 创建future
        FutureTask<String> stringFuture = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);

                return "Future--Test";
            }
        });
        // 线程执行
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(stringFuture);

        //2 //向ExecutorService提交一个Callable对象
        Future<String> future = executor.submit(new Callable<String>() {
            @Override
            public String call() throws InterruptedException {
                Thread.sleep(1000);
                //以异步方式在新线程中执行耗时的操作
                return "延时1秒";
            }
        });
        // 注意get会 阻塞当前调用线程
        System.out.println(stringFuture.get());

        System.out.println(future.get());
        executor.shutdown();

    }
}
