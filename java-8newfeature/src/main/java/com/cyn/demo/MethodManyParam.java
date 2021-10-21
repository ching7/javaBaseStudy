package com.cyn.demo;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-10-21
 */
public class MethodManyParam {

    @Test
    public void oneP() {
        testParam("123","22");
    }

    public void testParam(String... strs) {
        for (String str : strs) {
            System.out.println(str);
        }
    }
}
