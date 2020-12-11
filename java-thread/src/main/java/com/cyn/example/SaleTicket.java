package com.cyn.example;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/11
 * <p>
 * 三个售票员,卖30张票
 */
public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.saleTicket();
                }
            }
        }, "thread1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.saleTicket();
                }
            }
        }, "thread2").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.saleTicket();
                }
            }
        }, "thread3").start();
    }
}

class Ticket {
    private int number = 30;

    public void saleTicket() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "\t卖出第 " + number-- + "票\t剩下 " + number);
        } else {
            System.out.println(Thread.currentThread().getName() + "卖完了！！" + number);
        }
    }
}
