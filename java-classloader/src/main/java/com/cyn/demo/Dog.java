package com.cyn.demo;

/**
 * @author chenyanan
 * @date 2021/3/22
 * Created by chenyanan on 2021/3/22
 */
public class Dog extends Animal {
    private String name = "DOG name";

    public Dog() {
        super("s");
        System.out.println("我是Dog" + this.name);
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
    }
}
