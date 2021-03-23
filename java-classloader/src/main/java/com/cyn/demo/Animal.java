package com.cyn.demo;

/**
 * @author chenyanan
 * @date 2021/3/22
 * Created by chenyanan on 2021/3/22
 */
public class Animal extends ActionAbstract {
    public Animal() {
        System.out.println("我是Animal 无参");
    }

    public Animal(String name) {
        System.out.println("我是Animal 有参：" + name);
    }

    @Override
    public void eat() {

    }
}
