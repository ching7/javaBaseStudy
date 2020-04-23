package com.cyn.threadpool;

import java.util.concurrent.Callable;

/**
 * 文件描述
 *
 * @ProjectName: java-thread
 * @Package: com.cyn.threadpool
 * @Date 2020/4/23 10:31
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class ThreadTaskByCallable implements Callable<String> {
    private String taskName;

    public ThreadTaskByCallable(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String call() throws Exception {
        System.out.println(this.taskName +" 任务 callable 执行 ");
        return this.taskName +" 任务 callable 执行的返回值";
    }
}
