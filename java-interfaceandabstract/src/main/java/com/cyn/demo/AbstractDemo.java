package com.cyn.demo;

/**
 * @author chenyanan
 * Created by chenyanan on 2021/1/21
 */
public abstract class AbstractDemo {
    String tName = "AbstractDemo";

    public AbstractDemo() {
        System.out.println("AbstractDemo constructor");
    }

    public String getNameAbstractDemo() {
        System.out.println("public getNameAbstractDemo");
        return null;
    }

    abstract Integer getAgeAbstractDemo();

}
