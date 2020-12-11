package com.cyn.demo.threadsafe;

/**
 * 文件描述
 *
 * @ProjectName: java-threadcreate
 * @Package: com.cyn.threadsafe
 * @Date 2020/4/20 15:48
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: Java线程安全例子
 **/
public class Account {
    private String accountNo;
    // fixme:涉及金额需要使用bigdemical
    private double balance;

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
