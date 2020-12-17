package com.cyn.demo.singleton;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/17
 * 饿汉式单例在单例类被加载时候，就实例化一个对象并交给自己的引用；而懒汉式单例只有在真正使用的时候才会实例化一个对象并交给自己的引用
 */
public class LazySingleton {
    private static LazySingleton lazySingleton = null;

    private LazySingleton() {
        System.out.println(Thread.currentThread().getName() + "\t DclSingleton construct");

    }

    public static LazySingleton instance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

    public static void main(String[] args) {
        // 多线程存在问题
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                LazySingleton.instance();
            }, String.valueOf(i)).start();
        }
    }
}
