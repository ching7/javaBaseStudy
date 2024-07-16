package com.cyn.demo.bigdecimal;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @ClassName BigDeciamlDemo
 * @Description
 * @Author ynchen
 * @Date 2024/7/12 10:48
 * @Version V1.0.0
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        // 不要直接在构造方法中传入浮点数，会丢失精度
        BigDecimal demo1 = new BigDecimal("0.10");

        BigDecimal demo2 = BigDecimal.valueOf(0.10);
        // 比较用compare方法
        System.out.println(demo1.compareTo(demo2));
    }

    @Test
    public void doubleTest() {
        double v1 = 0.02;
        double v2 = 0.03;
        // 金额计算使用double会出现金额丢失
        // double会转化为二进制在进行计算，double16位计算会有丢失精度
        System.out.println(v2 - v1);
    }

    @Test
    public void bigDecimalTest() {
        BigDecimal v3 = new BigDecimal(0.02);
        BigDecimal v4 = new BigDecimal(0.03);
        // 使用double构造，会丢失精度
        System.out.println(v4.subtract(v3));

        BigDecimal v1 = BigDecimal.valueOf(0.02);
        BigDecimal v2 = BigDecimal.valueOf(0.03);
        // 使用string，或者使用valueOf，不会丢失精度
        System.out.println(v2.subtract(v1));

        // 不要直接在构造方法中传入浮点数，会丢失精度
        BigDecimal demo1 = new BigDecimal("0.1");
        BigDecimal demo2 = new BigDecimal("0.10");
        // 比较用compare方法
        System.out.println(demo1.equals(demo2));
        System.out.println(demo1.compareTo(demo2));

        // 精度指定和舍入
        System.out.println(v2.divide(v1, 2, BigDecimal.ROUND_HALF_DOWN));

        // 科学计数
        BigDecimal demo5 = BigDecimal.valueOf(123.123456789876564);
        BigDecimal demo6 = new BigDecimal("123.123456789876564");
        //
        System.out.println(demo5.toPlainString());
        System.out.println(demo5.toString());
        //
        System.out.println(demo6.toPlainString());
        System.out.println(demo6.toString());
    }
}
