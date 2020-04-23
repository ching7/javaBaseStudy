package com.cyn.threadpool;

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
        long[] numbers = LongStream.rangeClosed(1, 10000000).toArray();

        Instant start = Instant.now();
        Calculator calculator = new ForkJoinPoolDemo();
        long result = calculator.sumUp(numbers);
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis() + "ms");

        System.out.println("结果为：" + result);
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
