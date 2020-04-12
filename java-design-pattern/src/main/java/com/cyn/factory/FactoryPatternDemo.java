package com.cyn.factory;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/4/12
 */
public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        // 画圆
        Shape circle = shapeFactory.getShape("CIRCLE");
        circle.draw();
        // 画方形
        Shape square = shapeFactory.getShape("SQUARE");
        square.draw();
        // 画三角
        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        rectangle.draw();
    }
}
