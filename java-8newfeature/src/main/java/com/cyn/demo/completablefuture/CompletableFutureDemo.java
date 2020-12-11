package com.cyn.demo.completablefuture;

import java.util.concurrent.CompletableFuture;

/**
 * 文件描述
 *
 * @ProjectName: java-8newfeature
 * @Package: com.cyn.completablefuture
 * @Date 2020/4/24 19:38
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class CompletableFutureDemo {
    public static void main(String[] args) throws InterruptedException {
        // 4.2 创建异步任务
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(CompletableFutureDemo::taskt1);

        // 如果执行成功:
        cf.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 如果执行异常:
        cf.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(2000);
    }
    public static String taskt1(){
        try {
            Thread.sleep(1000);
            System.out.println("线程名：" + Thread.currentThread().getName() + " taskt1--exce ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程名：" + Thread.currentThread().getName() + " taskt1--res ";
    }
}
