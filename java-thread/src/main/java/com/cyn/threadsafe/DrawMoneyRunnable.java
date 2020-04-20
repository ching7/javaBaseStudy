package com.cyn.threadsafe;

/**
 * 文件描述
 *
 * @ProjectName: java-thread
 * @Package: com.cyn.threadsafe
 * @Date 2020/4/20 15:51
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class DrawMoneyRunnable implements Runnable {
    private  Account account;
    private double drawAmount;

    public DrawMoneyRunnable(Account account, double drawAmount) {
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        synchronized (account){
            if (account.getBalance() >= drawAmount) {
                System.out.println("取钱成功，取出：" + drawAmount);
                double balance = account.getBalance() - drawAmount;
                account.setBalance(balance);
                System.out.println("余额为：" + balance);
            }
        }

    }
}
