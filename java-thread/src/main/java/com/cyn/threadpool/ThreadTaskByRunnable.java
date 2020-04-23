package com.cyn.threadpool;

/**
 * 文件描述
 *
 * @ProjectName: java-threadcreate
 * @Package: com.cyn.threadpool
 * @Date 2020/4/20 19:02
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class ThreadTaskByRunnable implements Runnable {
    private String taskName;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public ThreadTaskByRunnable(String name) {
        this.setTaskName(name);
    }

    @Override
    public void run() {
        System.out.println("ThreadTaskByRunnable：" + taskName + "==" + Thread.currentThread().getName());
    }
}
