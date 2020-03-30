package com.cyn.strategy;

/**
 * 文件描述
 *
 * @ProjectName: java-design-pattern
 * @Package: com.cyn.strategy
 * @Date 2020/3/27 19:08
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: 策略选择类
 * <p>
 * 根据不同的选择返回不同的实例
 **/
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int excuteStrategy(int num1, int num2) {

        return strategy.doOperation(num1, num2);
    }

}
