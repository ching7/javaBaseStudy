package com.cyn.demo.bean;

import org.junit.Test;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-11-03
 */
public class BeanCopyTest {
    @Test
    public void testCopy() throws Exception {
        BeanSource beanSource = new BeanSource("王二", "123");
        BeanTarget clone = new BeanTarget();
        BeanCopyUtils.copy(beanSource,clone);
        System.out.println(clone);
    }
    @Test
    public void testCopy2() throws Exception {
        BeanSource beanSource = new BeanSource("王二", "123");
        BeanSource clone = (BeanSource)beanSource.clone();
        System.out.println(clone);
    }
}
