package com.cyn.demo.Threadlevel;

/**
 * 文件描述
 *
 * @ProjectName: java-threadcreate
 * @Package: com.cyn.Threadlevel
 * @Date 2020/4/20 16:32
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class DaemonThreadTest {
    public static void main(String[] args){

        Thread mainThread = new Thread(new Runnable(){
            @Override
            public void run(){
                Thread childThread = new Thread(new ChildThread());
                childThread.setDaemon(false);
                // 指定child为守护线程
                //childThread.setDaemon(true);
                childThread.start();
                System.out.println("I'm main threadcreate...");
            }
        });
        mainThread.start();
    }
}
