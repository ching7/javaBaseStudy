package com.cyn.threadpool;

/**
 * 文件描述
 *
 * @ProjectName: java-thread
 * @Package: com.cyn.threadpool
 * @Date 2020/4/20 19:02
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class ThreadTask implements Runnable {
    private String taskName;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public ThreadTask(String name) {
        this.setTaskName(name);
    }

    @Override
    public void run() {
        System.out.println("ThreadTask" + Thread.currentThread().getName());
    }
}
