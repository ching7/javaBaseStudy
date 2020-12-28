package com.cyn.demo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/26
 * <p>
 * 不存储元素的阻塞队列，也即单个元素的队列
 * put后必须要有take才可以添加元素
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                System.out.println("===" + Thread.currentThread().getName() + "\t put 1 ");
                blockingQueue.put("1");
                System.out.println("===" + Thread.currentThread().getName() + "\t put 2 ");
                blockingQueue.put("2");
                System.out.println("===" + Thread.currentThread().getName() + "\t put 3 ");
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AAA").start();
        new Thread(() -> {
            try {
                // 线程暂停3s
                TimeUnit.SECONDS.sleep(3);
                System.out.println("===" + Thread.currentThread().getName() + "\t  take" + blockingQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println("===" + Thread.currentThread().getName() + "\t  take" + blockingQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println("===" + Thread.currentThread().getName() + "\t  take" + blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "BBB").start();
    }
}
