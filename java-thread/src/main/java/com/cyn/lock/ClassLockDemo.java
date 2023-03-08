package com.cyn.lock;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2022-02-14
 */
public class ClassLockDemo {
    public static class TestSynchronized {
        public void test1() {
            synchronized (TestSynchronized.class) {
                int i = 5;
                while (i-- > 0) {
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ie) {
                    }
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
                    TestSynchronized.test2();
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
