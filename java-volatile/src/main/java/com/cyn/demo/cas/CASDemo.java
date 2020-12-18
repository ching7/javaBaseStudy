package com.cyn.demo.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/18
 * 乐观锁的一种实现：CAS
 * Compare And Swap 即比较和交换
 * <p>
 * 由于处理器缓存的存在，线程每次从主内存copy值到线程内存，线程修改后
 * 回写值的时候，需要再次判断修改前的值是否被其他线程修改回写过
 * 无修改就回写，有修改丢弃
 * <p>
 * 执行函数：CAS(V,E,N)
 * 其包含3个参数
 * V表示需要读写的内存位置
 * E表示进行比较的预期原值
 * N表示打算写入的新值
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        //
        boolean result = atomicInteger.compareAndSet(5, 2020);
        System.out.println("===" + result + "\t current data" + atomicInteger.get());

        boolean result1 = atomicInteger.compareAndSet(5, 2019);
        System.out.println("===" + result1 + "\t current data" + atomicInteger.get());

        // i++ 在多线程安全问题
        atomicInteger.getAndIncrement();
    }
}
