package com.cyn.demo.Threadlevel;

import java.util.concurrent.TimeUnit;

/**
 * 文件描述
 *
 * @ProjectName: java-threadcreate
 * @Package: com.cyn.Threadlevel
 * @Date 2020/4/20 16:33
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class ChildThread implements Runnable {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a threadcreate, starting the threadcreate causes the object's
     * <code>run</code> method to be called in that separately executing
     * threadcreate.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while(true){
            System.out.println("I'm child threadcreate..");
            try{
                TimeUnit.MILLISECONDS.sleep(1000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
