package com.cyn.Threadlevel;

import java.util.concurrent.TimeUnit;

/**
 * 文件描述
 *
 * @ProjectName: java-thread
 * @Package: com.cyn.Threadlevel
 * @Date 2020/4/20 16:33
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class ChildThread implements Runnable {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while(true){
            System.out.println("I'm child thread..");
            try{
                TimeUnit.MILLISECONDS.sleep(1000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
