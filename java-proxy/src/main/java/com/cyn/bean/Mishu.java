package com.cyn.bean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author chenyn
 * @version 1.0
 * @date 2019/8/29 23:29
 */
public class Mishu implements InvocationHandler {

    private Laozong laozong = new Laozong();
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("预约时间");
        Object result =  method.invoke(laozong,args);
        System.out.println("记录访客信息");
        return null;
    }
}
