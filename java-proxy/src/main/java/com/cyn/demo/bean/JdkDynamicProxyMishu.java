package com.cyn.demo.bean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author chenyanan
 * Created by chenyanan on 2021/1/15
 */
public class JdkDynamicProxyMishu implements InvocationHandler {
    //需要被动态代理的类
    private Object target;

    public JdkDynamicProxyMishu(Object target) {
        this.target = target;
    }

    /**
     * 获取被代理接口实例对象
     *
     * @param <T>
     * @return
     */
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /**
     * 代理调用被代理的类
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("dynamic before === proxy: method:" + method + " args:" + args);
        Object res = method.invoke(target, args);
        System.out.println("dynamic after === proxy: method:" + method + " args:" + args);
        return res;
    }
}
