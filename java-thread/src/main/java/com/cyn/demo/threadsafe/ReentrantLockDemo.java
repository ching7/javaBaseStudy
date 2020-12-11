package com.cyn.demo.threadsafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 文件描述
 *
 * @ProjectName: java-thread
 * @Package: com.cyn.threadsafe
 * @Date 2020/4/30 10:02
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: Java 5开始，引入了一个高级的处理并发的java.util.concurrent包，它提供了大量更高级的并发功能，能大大简化多线程程序的编写。
 **/
public class ReentrantLockDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ThreadTaskReentrant taskReentrant = new ThreadTaskReentrant("计算 ", 1);
        for (int i = 0; i < 10; i++){
            executorService.execute(taskReentrant);
        }
        Thread.sleep(1000);
        executorService.shutdownNow();
    }
}
