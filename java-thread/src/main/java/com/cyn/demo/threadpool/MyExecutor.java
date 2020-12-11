package com.cyn.demo.threadpool;

import java.util.concurrent.Executor;

/**
 * 文件描述
 *
 * @ProjectName: java-thread
 * @Package: com.cyn.threadpool
 * @Date 2020/4/22 19:59
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class MyExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        new Thread(command).run();
    }
}
