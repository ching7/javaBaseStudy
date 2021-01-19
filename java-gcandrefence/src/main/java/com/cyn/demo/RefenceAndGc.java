package com.cyn.demo;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author chenyanan
 * Created by chenyanan on 2021/1/19
 * 强引用、软引用、弱引用、虚引用
 */
public class RefenceAndGc {
    public static void main(String[] args) {
        RefenceAndGc refenceAndGc = new RefenceAndGc();
        refenceAndGc.fun1();
        refenceAndGc.fun2();
        refenceAndGc.fun3();
        refenceAndGc.fun4();
    }

    /**
     * 强引用
     */
    public void fun1() {
        Object object = new Object();
        Object[] objArr = new Object[1000];
    }

    /**
     * 软引用
     */
    public void fun2() {
        SoftReference<String> sr = new SoftReference<String>(new String("hello"));
        System.out.println(sr.get());
    }

    /**
     * 弱引用
     */
    public void fun3() {
        WeakReference<String> sr = new WeakReference<String>(new String("hello"));
        System.out.println(sr.get());
        System.gc();                //通知JVM的gc进行垃圾回收
        System.out.println(sr.get());
    }

    /**
     * 虚引用
     */
    public void fun4() {
        ReferenceQueue<String> queue = new ReferenceQueue<String>();
        PhantomReference<String> pr = new PhantomReference<String>(new String("hello"), queue);
        System.out.println(pr.get());
    }
}
