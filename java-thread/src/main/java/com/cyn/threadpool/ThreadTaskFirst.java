package com.cyn.threadpool;

/**
 * 文件描述
 *
 * @ProjectName: java-threadcreate
 * @Package: com.cyn.threadpool
 * @Date 2020/4/21 19:17
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class ThreadTaskFirst implements Runnable, Comparable<ThreadTaskFirst> {
    private int priority;

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public ThreadTaskFirst() {

    }

    public ThreadTaskFirst(int priority) {
        this.priority = priority;
    }

    /**
     * 当前对象和其他对象做比较，当前优先级大就返回-1，优先级小就返回1,值越小优先级越高
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(ThreadTaskFirst o) {
        return this.priority > o.priority ? 1 : -1;
    }

    @Override
    public void run() {
        try {
            //让线程阻塞，使后续任务进入缓存队列
            Thread.sleep(1000);
            System.out.println("priority:" + this.priority + ",ThreadName:" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
