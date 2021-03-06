package com.cyn.demo.threadcommunity;

/**
 * 文件描述
 *
 * @ProjectName: java-threadcreate
 * @Package: com.cyn.threadcommunity
 * @Date 2020/4/20 16:17
 * @Author: chenyn22577
 * @Version: 1.0
 * 线程通信
 * wait notify sync
 * <p>
 * await singal lock
 **/
public class ThreadTest {
    public static void main(String[] args) {
        Account account = new Account("123456", 0);

        Thread drawMoneyThread = new DrawMoneyThread("取钱线程", account, 700);
        Thread depositeMoneyThread = new DepositeMoneyThread("存钱线程", account, 700);

        drawMoneyThread.start();
        depositeMoneyThread.start();
    }
}
