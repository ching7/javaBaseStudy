package com.cyn.threadcreate;

import java.time.LocalTime;

/**
 * 文件描述
 *
 * @ProjectName: java-thread
 * @Package: com.cyn.threadcreate
 * @Date 2020/4/29 20:13
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class ThreadDaemon extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println(LocalTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
