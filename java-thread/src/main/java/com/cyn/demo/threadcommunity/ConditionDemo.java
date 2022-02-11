package com.cyn.demo.threadcommunity;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: Condition是在java 1.5中才出现的，它用来替代传统的Object的wait()、notify()实现线程间的协作，相比使用Object的wait()、notify()
 * 使用Condition的await()、signal()这种方式实现线程间协作更加安全和高效。因此通常来说比较推荐使用Condition，阻塞队列实际上是使用了Condition来模拟线程间协作
 * @Author: ynchen9
 * @CreateTime: 2022-02-11
 */
public class ConditionDemo {
    final Lock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ConditionDemo test = new ConditionDemo();
        Producer producer = test.new Producer();
        Consumer consumer = test.new Consumer();


        consumer.start();
        producer.start();
    }

    class Consumer extends Thread {

        @Override
        public void run() {
            consume();
        }

        private void consume() {
            try {
                lock.lock();
                currentThread().setName("consume");
                System.out.println("我在等一个新信号" + currentThread().getName());
                condition.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                System.out.println("拿到一个信号" + currentThread().getName());
                lock.unlock();
            }

        }
    }

    class Producer extends Thread {

        @Override
        public void run() {
            produce();
        }

        private void produce() {
            try {
                lock.lock();
                currentThread().setName("produce");

                System.out.println("我拿到锁" + currentThread().getName());
                condition.signalAll();
                System.out.println("我发出了一个信号：" + currentThread().getName());
            } finally {
                lock.unlock();
            }
        }
    }
}
