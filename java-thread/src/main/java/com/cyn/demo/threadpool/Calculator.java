package com.cyn.demo.threadpool;

/**
 * 文件描述
 *
 * @ProjectName: java-thread
 * @Package: com.cyn.threadpool
 * @Date 2020/4/23 19:33
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: 求合接口
 **/
public interface Calculator {
    /**
     * 求合
     * @param numbers
     * @return
     */
    long sumUp(long[] numbers);
}
