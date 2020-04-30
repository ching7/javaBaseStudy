package com.cyn.threadsafe;

/**
 * 文件描述
 *
 * @ProjectName: java-thread
 * @Package: com.cyn.threadsafe
 * @Date 2020/4/30 10:07
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class ThreadTaskReentrant implements Runnable {
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
    private String name;
    private int count;
    ReentrantLockClass countT = new ReentrantLockClass();

    public ThreadTaskReentrant(String name, int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public void run() {
        int res = 0;
        try {
            res = countT.add(this.count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "==" + this.name + "==结果" + res);
    }
}
