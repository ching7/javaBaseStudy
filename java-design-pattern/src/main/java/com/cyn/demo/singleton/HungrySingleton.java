package com.cyn.demo.singleton;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/17
 * 饿汉式单例在单例类被加载时候，就实例化一个对象并交给自己的引用；而懒汉式单例只有在真正使用的时候才会实例化一个对象并交给自己的引用
 */
public class HungrySingleton {
    private static HungrySingleton hungrySingleton;

    private HungrySingleton() {

    }

    public static HungrySingleton getHungrySingleton() {
        return hungrySingleton;
    }
}
