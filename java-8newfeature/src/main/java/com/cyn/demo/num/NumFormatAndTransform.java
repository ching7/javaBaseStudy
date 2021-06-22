package com.cyn.demo.num;

import org.junit.Test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-06-18
 */
public class NumFormatAndTransform {
    @Test
    public void testNum2Percentage() {
        double num = 0.56966;
        AtomicInteger historyCallCount = new AtomicInteger();
        historyCallCount.set(12);
        AtomicInteger historyCallCountSuccess = new AtomicInteger();
        historyCallCountSuccess.set(122);
        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        //保留到小数点后2位,不设置或者设置为0表示不保留小数
        numberFormat.setMinimumFractionDigits(2);
        double res1 = (double) historyCallCount.get() / (double) historyCallCountSuccess.get();
        //小数保留2个精度转String
        DecimalFormat df = new DecimalFormat("0.00");
        String dr = df.format(res1);
        double i = historyCallCount.get();
        double i1 = historyCallCountSuccess.get();
        double res = i / i1;
        //结果56.97%
        System.out.println(numberFormat.format(res));
    }

    @Test
    public void int2Double() {
        System.out.println((double) 1);
    }
}
