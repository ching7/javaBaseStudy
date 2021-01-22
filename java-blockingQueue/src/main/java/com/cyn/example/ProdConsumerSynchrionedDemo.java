package com.cyn.example;

/**
 * @author chenyanan
 * Created by chenyanan on 2021/1/22
 */
public class ProdConsumerSynchrionedDemo {
    public static void main(String[] args) {
        ShareData1 ShareData1 = new ShareData1();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    ShareData1.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    ShareData1.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }

    }
}

class ShareData1 { //资源类
    private int number = 0;


    public synchronized void increment() throws Exception {
        while (number != 0) {
            this.wait();
        }
        number++;
        System.out.println("===" + Thread.currentThread().getName() + "\t add:" + number);
        this.notifyAll();
    }

    public synchronized void decrement() throws Exception {
        while (number == 0) {
            this.wait();
        }
        number--;
        System.out.println("===" + Thread.currentThread().getName() + "\t dec:" + number);
        this.notifyAll();
    }
}
