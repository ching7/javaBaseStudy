package com.cyn.demo.bean;

/**
 * @author chenyanan
 * Created by chenyanan on 2021/1/15
 */
public class Laozong2 implements Gongneng {
    @Override
    public void chifan() {
        System.out.println("老板2吃饭");
    }

    @Override
    public String xiaomubiao() {
        System.out.println("老板2的小目标");
        return "老板2的小目标";
    }

    @Override
    public String jianghua(String msg) {
        System.out.println("老板2讲话：" + msg);
        return "老板2讲话：" + msg;
    }
}
