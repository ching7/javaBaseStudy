package com.cyn.demo.threadsafe;

/**
 * 文件描述
 *
 * @ProjectName: java-threadcreate
 * @Package: com.cyn.threadsafe
 * @Date 2020/4/20 15:54
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class SafeDemo {
    public static void main(String[] args) {
        Account account = new Account("123456", 1000);
        //
        DrawMoneyRunnable drawMoneyRunnable = new DrawMoneyRunnable(account,700);
        Thread thread1 = new Thread(drawMoneyRunnable);
        Thread thread2 = new Thread(drawMoneyRunnable);

        thread1.start();
        thread2.start();

    }
}
