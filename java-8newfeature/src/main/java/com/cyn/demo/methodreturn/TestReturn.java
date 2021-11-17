package com.cyn.demo.methodreturn;

import org.junit.Test;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-10-25
 */
public class TestReturn {

    @Test
    public void testReturn() {
        returnMethod("123");

        System.out.println("test");
    }

    public String returnMethod(String string) {
        System.out.println(string);
        return string;
    }

    @Test
    public void testReturn2() {
        new Thread(() -> {
            testReturn3();
        }, "testReturn2").start();

        System.out.println("test");
    }

    public void testReturn3() {
        System.out.println("testReturn3");
    }
}
