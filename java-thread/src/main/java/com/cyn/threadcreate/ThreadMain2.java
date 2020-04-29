package com.cyn.threadcreate;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 文件描述
 *
 * @ProjectName: java-thread
 * @Package: com.cyn.threadcreate
 * @Date 2020/4/28 16:32
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class ThreadMain2 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        ThreadDemoByRunnable task = new ThreadDemoByRunnable("测试");
        int count = 3;
        while (count > 0) {
            executor.execute(task);
            count--;
        }
        Thread.sleep(100);
        task.running = false;
        ThreadDaemon timer = new ThreadDaemon();
        timer.setDaemon(true);

        executor.execute(timer);
        executor.shutdownNow();
    }
}
