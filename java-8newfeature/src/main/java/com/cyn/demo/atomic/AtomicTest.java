package com.cyn.demo.atomic;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-12-20
 */
public class AtomicTest {
    @Test
    public void testInit() {
        AtomicReference<Date> hangupTime = new AtomicReference<>();
        System.out.println(hangupTime.get() == null);
    }
}
