package com.cyn.demo.singleton;

/**
 * 文件描述
 *
 * @ProjectName: javaBaseStudy
 * @Package: com.cyn.singleton
 * @Date 2020/4/14 18:35
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: 双检锁/双重校验锁（DCL，即 double-checked locking）
 * JDK 版本：JDK1.5 起
 * <p>
 * 是否 Lazy 初始化：是
 * <p>
 * 是否多线程安全：是
 * <p>
 * 实现难度：较复杂
 * <p>
 * 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 * getInstance() 的性能对应用程序很关键。
 **/
public class DclSingleton {
    /**
     * 确保编译器不适用缓存，每次重新加载
     */
    private volatile static DclSingleton dclSingleton;

    private DclSingleton() {
    }

    public static DclSingleton getInstance() {
        if (dclSingleton == null) {
            // 确保线程安全
            synchronized (DclSingleton.class) {
                if (dclSingleton == null) {
                    dclSingleton = new DclSingleton();
                }
            }
        }
        return dclSingleton;
    }

    public void putMessage() {
        System.out.println("单例初始化");
    }
}
