package com.cyn.abstractfactory;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/4/13
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if ("SHAPE".equalsIgnoreCase(choice)){
            return new ShapeFactory();
        } else if("COLOR".equalsIgnoreCase(choice)){
            return new ColorFactory();
        }
        return null;
    }
}
