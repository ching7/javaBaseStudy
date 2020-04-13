package com.cyn.abstractfactory;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/4/12
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method. !!");
    }
}
