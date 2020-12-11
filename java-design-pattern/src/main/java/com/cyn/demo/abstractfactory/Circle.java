package com.cyn.demo.abstractfactory;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/4/12
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
