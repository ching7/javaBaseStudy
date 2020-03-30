package com.cyn.strategy;

/**
 * 文件描述
 *
 * @ProjectName: java-design-pattern
 * @Package: com.cyn.strategy
 * @Date 2020/3/27 19:06
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: 乘法
 **/
public class StrategyMultiply implements Strategy {
    public int doOperation(int num1, int num2) {
        System.out.println(num1 * num2);
        return num1 * num2;
    }
}
