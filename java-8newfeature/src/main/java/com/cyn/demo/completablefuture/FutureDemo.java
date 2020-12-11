package com.cyn.demo.completablefuture;

import java.util.Random;
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
    public static void main(String[] args) throws Exception {
        // jdk自带线程池
        ExecutorService executor = Executors.newCachedThreadPool();
        // 1 创建future
        /*FutureTask<String> stringFuture = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);

                return "Future--Test";
            }
        });
        // 线程执行
        executor.execute(stringFuture);*/

        //2 //向ExecutorService提交一个Callable对象
        /*Future<String> future = executor.submit(new Callable<String>() {
            @Override
            public String call() throws InterruptedException {
                Thread.sleep(1000);
                //以异步方式在新线程中执行耗时的操作
                return "延时1秒";
            }
        });
        // 注意get会 阻塞当前调用线程
        System.out.println(stringFuture.get());

        System.out.println(future.get());*/

        // 3 多线程使用FutureTask,等待线程返回值,会造成线程等待，失去线程并行
        /*for (int i = 0; i < 10; i++) {
            int finalI = i;
            FutureTask<String> stringFuture = new FutureTask<String>(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(1000);
                    return Thread.currentThread().getName() + " Future--Test " + finalI;
                }
            });
            executor.execute(stringFuture);
            System.out.println(stringFuture.get());
        }*/

        // 4 多线程异步等待
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            // 4.1
            TaskT taskT = new TaskT(finalI + "");
            // taskT.call();
            // executor.execute();
            Future<String> future =  executor.submit(taskT);
            System.out.println(future.get());


        }
         executor.shutdown();
    }

    public static class TaskT implements Callable<String> {
        String name;

        public TaskT(String name) {
            this.name = name;
        }

        @Override
        public String call() throws Exception {
            try {
                Thread.sleep(1000);
                System.out.println("线程名：" + Thread.currentThread().getName() + "== 任务名：" + this.name + " Task--exce ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "线程名：" + Thread.currentThread().getName() + "== 任务名：" + this.name + " Task--res ";
        }
    }

}
