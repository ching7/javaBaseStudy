package com.cyn.demo.singleton;

import com.cyn.demo.singleton.demo.CommandBean;

/**
 * 文件描述
 *
 * @ProjectName: java-design-pattern
 * @Package: com.cyn.singleton
 * @Date 2020/4/14 18:45
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description:
 * JDK 版本：JDK1.5 起
 *
 * 是否 Lazy 初始化：否
 *
 * 是否多线程安全：是
 *
 * 实现难度：易
 *
 * 描述：这种实现方式还没有被广泛采用，但这是实现单例模式的最佳方法。它更简洁，自动支持序列化机制，绝对防止多次实例化。
 * 这种方式是 Effective Java 作者 Josh Bloch 提倡的方式，它不仅能避免多线程同步问题，而且还自动支持序列化机制，防止反序列化重新创建新的对象，绝对防止多次实例化。不过，由于 JDK1.5 之后才加入 enum 特性，用这种方式写不免让人感觉生疏，在实际工作中，也很少用。
 * 不能通过 reflection attack 来调用私有构造方法。
 **/
public enum  EnumSingleton {
    /**
     *
     */
    INSTANCE;

    /**
     * CacheFileUtil实体
     */
    private final CommandBean instance;

    /**
     * 枚举构造方式
     */
    EnumSingleton() {
        this.instance = new CommandBean();
    }

    /**
     * 获取单实例接口
     *
     * @return
     */
    public CommandBean getInstance() {
        return instance;
    }

    /**
     *
     */
    public void whateverMethod() {
        System.out.println("EnumSingle !");
    }
}
