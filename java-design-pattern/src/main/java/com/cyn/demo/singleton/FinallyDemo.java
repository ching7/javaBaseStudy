package com.cyn.demo.singleton;


/**
 * @author chenyanan
 * @date 2021/1/29
 * Created by chenyanan on 2021/1/29
 */
public class FinallyDemo {
    public static void main(String[] args) {
        int demo = getDemo();
    }

    public static int getDemo() {
        int a = 3;
        try {
            return a;
        } catch (Exception e) {

        } finally {
            a = 4;
            return a;
        }
    }
}
