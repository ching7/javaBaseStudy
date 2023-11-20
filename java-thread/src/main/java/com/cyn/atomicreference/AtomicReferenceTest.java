package com.cyn.atomicreference;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @ClassName AtomicReferenceTest
 * @Description
 * @Author ynchen
 * @Date 2023/9/15 15:52
 * @Version V1.0.0
 */
public class AtomicReferenceTest {

    public static ThreadPoolExecutor AOP_REPORT_ADD_POOL;
    public static ThreadFactory aopReportThreadFactory = new ThreadFactoryBuilder().setNameFormat("aop-report-add-pool-%d").build();

    static {


        AOP_REPORT_ADD_POOL = new ThreadPoolExecutor(10, 200, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1000), aopReportThreadFactory);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            //AOP_REPORT_ADD_POOL.execute(() -> {
            long nowTime = System.currentTimeMillis();
            addMethod();
            long nowTime2 = System.currentTimeMillis();
            System.out.println(nowTime2);
            //});
        }
    }

    static void addMethod() {
        AOP_REPORT_ADD_POOL.execute(() -> {
            AtomicReference<Boolean> res = new AtomicReference<>();

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            res.getAndSet(true);
            System.out.printf(String.valueOf(res.get()));

        });

    }
}
