package com.cyn.completablefuture;

import java.util.concurrent.CompletableFuture;

/**
 * 文件描述
 *
 * @ProjectName: java-8newfeature
 * @Package: com.cyn.completablefuture
 * @Date 2020/4/24 19:46
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class CompletableFutureDemo2 {
    public static void main(String[] args) throws Exception {
        // 第一个任务:
        CompletableFuture<String> cfQuery = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油");
        });
        // cfQuery成功后继续执行下一个任务:
        CompletableFuture<Double> cfFetch = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice(code);
        });
        // cfFetch成功后打印结果:
        cfFetch.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(5000);
    }

    static String queryCode(String name) {
        try {
            Thread.sleep(1000);
            System.out.println("queryCode "+name);
        } catch (InterruptedException e) {
        }
        return "601857";
    }

    static Double fetchPrice(String code) {
        try {
            Thread.sleep(1000);
            System.out.println("fetchPrice "+code);
        } catch (InterruptedException e) {
        }
        return 5 + Math.random() * 20;
    }
}