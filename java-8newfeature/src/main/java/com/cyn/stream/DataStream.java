package com.cyn.stream;

import java.util.stream.IntStream;

/**
 * 文件描述
 *
 * @ProjectName: java-8newfeature
 * @Package: com.cyn.stream
 * @Date 2020/4/23 19:48
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: 数值流
 * Java 8 有良心地引入了数值流 IntStream, DoubleStream, LongStream，这种流中的元素都是原始数据类型，分别是 int，double，long
 **/
public class DataStream {
    //rangeClosed(1, 100) ：[1, 100]
    //range(1, 100) ：[1, 100)
    //求 1 到 10 的数值总和：
    public static void main(String[] args) {
        IntStream intStream = IntStream.rangeClosed(1, 10);
        System.out.println(intStream.sum());
    }

}
