package com.cyn.demo.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class NewMishu implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib 输出预约时间");
        Object result =  methodProxy.invokeSuper(o,objects);
        System.out.println("cglib 输出记录访客信息");
        return result;
    }
}
