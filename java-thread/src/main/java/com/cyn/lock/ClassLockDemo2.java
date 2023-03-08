package com.cyn.lock;

/**
 * @Description:
 * 线程可以同时获取一个类锁，和对象锁
 * @Author: ynchen9
 * @CreateTime: 2022-02-14
 */
public class ClassLockDemo2 {
    public static class TestSynchronized {
        public synchronized void test1() {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
        }

        public static synchronized void test2() {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
        }

        public static void main(String[] args) {
            final TestSynchronized myt2 = new TestSynchronized();
            Thread test1 = new Thread(new Runnable() {
                public void run() {
                    myt2.test1();
                }
            }, "test1");
            Thread test2 = new Thread(new Runnable() {
                public void run() {
                    test2();
                }
            }, "test2");
            test1.start();
            test2.start();
            //         TestRunnable tr=new TestRunnable();
            //         Thread test3=new Thread(tr);
            //         test3.start();
        }
    }
}
