package com.cyn.lock;

/**
 * @Description: java的内置锁：每个java对象都可以用做一个实现同步的锁，这些锁成为内置锁。
 * 线程进入同步代码块或方法的时候会自动获得该锁，在退出同步代码块或方法时会释放该锁。获得内置锁的唯一途径就是进入这个锁的保护的同步代码块或方法。
 * <p>
 * java的对象锁和类锁：java的对象锁和类锁在锁的概念上基本上和内置锁是一致的，但是，两个锁实际是有很大的区别的，
 * 对象锁是用于对象实例方法，或者一个对象实例上的，
 * 类锁是用于类的静态方法或者一个类的class对象上的。
 * 我们知道，类的对象实例可以有很多个，但是每个类只有一个class对象，所以不同对象实例的对象锁是互不干扰的，
 * 但是每个类只有一个类锁。但是有一点必须注意的是，其实类锁只是一个概念上的东西，并不是真实存在的，它只是用来帮助我们理解锁定实例方法和静态方法的区别的
 * @Author: ynchen9
 * @CreateTime: 2022-02-14
 */
public class ObjectLockDemo {
    // 对象锁
    public static void main(String[] args) {
        final TestSynchronized myt2 = new TestSynchronized();
        Thread test1 = new Thread(new Runnable() {
            public void run() {
                myt2.test1();
            }
        }, "test1");
        Thread test2 = new Thread(new Runnable() {
            public void run() {
                myt2.test2();
            }
        }, "test2");
        test1.start();
        test2.start();
//         TestRunnable tr=new TestRunnable();
//         Thread test3=new Thread(tr);
//         test3.start();
    }

    static class TestSynchronized {
        public void test1() {
            synchronized (this) {
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

//        public synchronized void test2() {
//            int i = 5;
//            while (i-- > 0) {
//                System.out.println(Thread.currentThread().getName() + " : " + i);
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException ie) {
//                }
//            }
//        }
        public  void test2() {
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
}
