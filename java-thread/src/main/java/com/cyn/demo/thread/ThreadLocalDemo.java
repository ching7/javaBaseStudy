package com.cyn.demo.thread;

/**
 * @author chenyanan
 * Created by chenyanan on 2021/1/7
 * <p>
 * ThreadLocal是一个本地线程副本变量工具类
 */
public class ThreadLocalDemo {
    // 创建ThreadLocal私有属性实例,重写initialValue执行初始值
    private static ThreadLocal<Integer> num = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    //更新值
    public int getNextNum() {
        num.set(num.get() + 1);
        return num.get();
    }

    /**
     * 官方解释：
     * 删除此线程局部变量的当前线程值。
     * 如果此线程局部变量随后被当前线程读取，则除非调用中间线程的当前线程设置其值，否则将通过调用其initialValue方法来重新初始化其值。
     * 这可能导致当前线程中多次调用initialValue方法
     * <p>
     * 清空ThreadLocal的值为null，加快GC,减少内存占用
     */
    public void removeNum() {
        num.remove();
    }
}
