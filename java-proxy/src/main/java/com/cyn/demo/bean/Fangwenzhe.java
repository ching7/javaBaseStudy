package com.cyn.demo.bean;

import java.lang.reflect.Proxy;

/**
 * @author chenyn
 * @version 1.0
 * @date 2019/8/29 23:34
 */
public class Fangwenzhe {
    public static void main(String[] args) {
        // jdk动态代理的实现方法
        Mishu mishu = new Mishu();
        // 参数1 反射时使用的类加载器
        // 参数2 Proxy需要实现的接
        // 参数3 通过接口方法调用方法时，需要调用哪个类的invoke方法
        Gongneng gongneng = (Gongneng) Proxy.newProxyInstance(Mishu.class.getClassLoader(),new Class[]{Gongneng.class},mishu);

        gongneng.chifan();
        gongneng.xiaomubiao();
    }
}
