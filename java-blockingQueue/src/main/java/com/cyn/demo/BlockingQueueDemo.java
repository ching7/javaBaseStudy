package com.cyn.demo;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/26
 * <p>
 * 1 队列
 * <p>
 * 2 阻塞队列
 * 2.1 阻塞队列的用途
 * 2.2 如何管理堵塞队列
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        // List list = null;

        // add remove element 不符合调节抛出异常
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(3);
        /*System.out.println("===" + blockingQueue.add("a"));
        System.out.println("===" + blockingQueue.add("b"));
        System.out.println("===" + blockingQueue.add("c"));*/
        // System.out.println("===" + blockingQueue.add("a"));

        // System.out.println("===" + blockingQueue.remove());
        // System.out.println("===" + blockingQueue.remove());
        // System.out.println("===" + blockingQueue.remove());
        // System.out.println("===" + blockingQueue.remove());
        /*System.out.println("===" + blockingQueue.element());*/

        // offer poll peek 异常返回null
        /*System.out.println("===" + blockingQueue.offer("a"));
        System.out.println("===" + blockingQueue.offer("b"));
        System.out.println("===" + blockingQueue.offer("c"));
        System.out.println("===" + blockingQueue.offer("a"));

        System.out.println("===" + blockingQueue.poll());
        System.out.println("===" + blockingQueue.poll());
        System.out.println("===" + blockingQueue.poll());
        System.out.println("===" + blockingQueue.poll());
        System.out.println("===" + blockingQueue.poll());

        System.out.println("===" + blockingQueue.peek());*/


        // put take 线程阻塞
        blockingQueue.put("rab");
        blockingQueue.put("b");
        blockingQueue.put("b");


        System.out.println("===" + blockingQueue.take());
        System.out.println("===" + blockingQueue.take());
        System.out.println("===" + blockingQueue.take());
        System.out.println("===" + blockingQueue.take());
    }
}
