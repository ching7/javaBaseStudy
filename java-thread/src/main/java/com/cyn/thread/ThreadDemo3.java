package com.cyn.thread;

import java.util.concurrent.Callable;

/**
 * 文件描述
 *
 * @ProjectName: java-thread
 * @Package: com.cyn.thread
 * @Date 2020/4/15 16:13
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: 使用Callable和Future接口创建线程。
 * <p>
 * 具体是创建Callable接口的实现类，并实现call()方法。
 * 并使用FutureTask类来包装Callable实现类的对象，且以此FutureTask对象作为Thread对象的target来创建线程。
 **/
public class ThreadDemo3 implements Callable<Integer> {
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        System.out.println("子线程:" + Thread.currentThread().getName());
        Thread.sleep(4000);
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        System.out.println("子线程运行结果,sum = " + sum);
        return sum;
    }
}
