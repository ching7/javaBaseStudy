package com.cyn.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/30
 * 阻塞队列-生产者消费者
 * <p>
 * Volatile/cas/atomicInteger/BlcokQueue/线程交互/原子引用
 */
public class ProdConsumerBlockQueueDemo {
    public static void main(String[] args) {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(2));
        new Thread(() -> {
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Pord").start();
        new Thread(() -> {
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Consumer").start();

        // 线程暂停3s
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("===" + Thread.currentThread().getName() + "\t 生产消费5秒，变更flag，停止消费");
        myResource.stop();
    }

}

class MyResource {
    private volatile boolean Flag = true;//默认开启进行生产消费,并发情况下使用volatile保证变量可见性
    private AtomicInteger atomicInteger = new AtomicInteger(); //线程共享资源

    BlockingQueue<String> blockingQueue = null;

    //spring注入。get\set 、construct注入
    public MyResource(BlockingQueue<String> blockingQueue) {
        //传入接口,而不是具体实现类，保证程序可用性
        System.out.println("===" + blockingQueue.getClass().getName());// 打印具体的实现类，保证日志排查
        this.blockingQueue = blockingQueue;
    }

    /**
     * 生产
     *
     * @throws Exception
     */
    public void myProd() throws Exception {
        String data = null;
        boolean reVal;
        while (Flag) {
            data = atomicInteger.incrementAndGet() + "";//类似++i
            reVal = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);//2秒内传一个
            if (reVal) {
                System.out.println("===" + Thread.currentThread().getName() + "\t 插入队列" + data + "成功");
            } else {
                System.out.println("===" + Thread.currentThread().getName() + "\t 插入队列" + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("===" + Thread.currentThread().getName() + "\t 停止prod,flag:" + Flag);
    }

    /**
     * 消费
     *
     * @throws Exception
     */
    public void myConsumer() throws Exception {
        String reVal;
        while (Flag) {
            reVal = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (null == reVal || "".equalsIgnoreCase(reVal)) {
                Flag = false;
                System.out.println("===" + Thread.currentThread().getName() + "\t 停止consumer,flag:" + Flag);
                return;
            }
            System.out.println("===" + Thread.currentThread().getName() + "\t 消费成功,reVal:" + reVal);
        }
    }

    public void stop() {
        this.Flag = false;
    }
}