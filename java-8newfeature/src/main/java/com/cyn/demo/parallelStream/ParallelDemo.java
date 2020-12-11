package com.cyn.demo.parallelStream;

import java.util.Arrays;
import java.util.List;

/**
 * 文件描述
 *
 * @ProjectName: java-8newfeature
 * @Package: com.cyn.parallelStream
 * @Date 2020/4/24 10:46
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: parallelStream提供了流的并行处理，它是Stream的另一重要特性，其底层使用Fork/Join框架实现。简单理解就是多线程异步任务的一种实现。
 **/
public class ParallelDemo {
    public static void main(String[] args) throws InterruptedException {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.stream()
                .forEach(num -> System.out.println(" >>>> " + num));
        System.out.println("---------");

        numbers.parallelStream()
                .forEach(num -> System.out.println(" >>>> " + num));
        System.out.println("---------");

        numbers.parallelStream()
                .forEach(num -> System.out.println(Thread.currentThread().getName() + " >>>> " + num));
        System.out.println("=========");

//        Thread thread1 = new Thread(() -> {
//            streamTest1();
//        });
//
//        Thread thread2 = new Thread(() -> {
//            streamTest2();
//        });
//
//        thread1.start();
//        thread2.start();
//
//        thread1.join();
//        thread2.join();
    }

    //stream
    public static void streamTest1() {
        try {
            List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
            integers.parallelStream().forEach(num -> {
                System.out.println("streamTest1第一次请求并行：" + Thread.currentThread().getName() + " >>>> " + num);
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //stream
    public static void streamTest2() {
        try {
            List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
            integers.parallelStream().forEach(num -> {
                System.out.println("streamTest2第二次请求并行：" + Thread.currentThread().getName() + " >>>> " + num);
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
