package com.cyn.demo.threadpool;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

/**
 * 文件描述
 *
 * @ProjectName: java-thread
 * @Package: com.cyn.threadpool
 * @Date 2020/4/23 19:19
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description:  ForkJoinPoolDemo 的适用场景，实现原理
 **/
public class ForkJoinPoolDemo implements Calculator{
    public static void main(String[] args) {
        // 问题：计算1至10000000的正整数之和。

        // 方案一：最为普通的for循环解决
        // 最简单的，显然是不使用任何并行编程的手段，只用最直白的 for-loop 来实现。下面就是具体的实现代码。
        // 为了面向接口编程，下面我们把计算的方法定义成接口，不同的方案书写不同的实现即可
//        long[] numbers1 = LongStream.rangeClosed(1, 100000000).toArray();
//
//        Instant start1 = Instant.now();
//        Calculator calculator = new ForkJoinPoolDemo();
//        long result1 = calculator.sumUp(numbers1);
//        Instant end1 = Instant.now();
//        System.out.println("方案一耗时：" + Duration.between(start1, end1).toMillis() + "ms");
//        System.out.println("方案一结果为：" + result1);

        //方案二：ExecutorService多线程方式实现
        /*long[] numbers2 = LongStream.rangeClosed(1, 100000000).toArray();
        Instant start2 = Instant.now();
        Calculator calculator2 = new ExecutorServiceCalculator();
        long resul2t = calculator2.sumUp(numbers2);
        Instant end2 = Instant.now();
        System.out.println("方案二耗时：" + Duration.between(start2, end2).toMillis() + "ms");
        // 打印结果500500
        System.out.println("方案二结果为：" + resul2t);*/

        // 方案3
        Instant start3 = Instant.now();
        long d=0L;
        for (long i = 0; i < 10000000000L; i++) {
            d = d+i;
        }
        Instant end3 = Instant.now();
        System.out.println("方案3耗时：" + Duration.between(start3, end3).toMillis() + "ms");
        // 打印结果500500
        System.out.println("方案3结果为：" + d);

        // 方案4 ForkJoinPool 的实现方法。
        long[] numbers2 = LongStream.rangeClosed(1, 100000000).toArray();
        Instant start2 = Instant.now();
        Calculator calculator2 = new ForkJoinCalculator();
        long resul2t = calculator2.sumUp(numbers2);
        Instant end2 = Instant.now();
        System.out.println("方案4耗时：" + Duration.between(start2, end2).toMillis() + "ms");
        System.out.println("方案4结果为：" + resul2t);

        // 方案5 采用并行流（JDK8以后的推荐做法） 并行流底层还是Fork/Join框架，只是任务拆分优化得很好。
        /*Instant start = Instant.now();
        long result = LongStream.rangeClosed(0, 100000000).parallel().reduce(0, Long::sum);
        Instant end = Instant.now();
        System.out.println("方案5耗时：" + Duration.between(start, end).toMillis() + "ms");
        System.out.println("方案5结果为：" + result); */
    }

    /**
     * 求合
     *
     * @param numbers
     * @return
     */
    @Override
    public  long sumUp(long[] numbers) {
        long total = 0;
        for (long i : numbers) {
            total += i;
        }
        return total;
    }
}
