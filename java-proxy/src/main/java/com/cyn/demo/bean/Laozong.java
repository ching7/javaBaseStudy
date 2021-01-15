package com.cyn.demo.bean;

/**
 * @author chenyn
 * @version 1.0
 * @date 2019/8/29 23:27
 */
public class Laozong implements Gongneng {


    @Override
    public void chifan() {
        System.out.println("老板1吃饭");
    }

    @Override
    public String xiaomubiao() {
        System.out.println("老板1的小目标");
        return "老板1的小目标";
    }

    @Override
    public String jianghua(String msg) {
        System.out.println("老板1讲话："+msg);
        return "老板1讲话："+msg;
    }
}
