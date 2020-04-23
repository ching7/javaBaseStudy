package com.cyn.threadcommunity;

/**
 * 文件描述
 *
 * @ProjectName: java-threadcreate
 * @Package: com.cyn.threadcommunity
 * @Date 2020/4/20 16:16
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class DepositeMoneyThread extends  Thread{
    private Account account;
    private double amount;

    public DepositeMoneyThread(String threadName, Account account, double amount) {
        super(threadName);
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.deposite(amount, i);
        }
    }
}
