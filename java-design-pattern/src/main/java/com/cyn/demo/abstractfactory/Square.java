package com.cyn.demo.abstractfactory;

/**
 * @author chenyanan
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method. ! ");
    }
}
