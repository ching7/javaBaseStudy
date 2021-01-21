package com.cyn.demo;

/**
 * @author chenyanan
 * Created by chenyanan on 2021/1/21
 */
public class DemoMain extends AbstractDemo implements InterfaceDemo {
    public static void main(String[] args) {
        DemoMain demoMain = new DemoMain();
        demoMain.getAgeAbstractDemo();
        InterfaceDemo.getInit();
    }

    @Override
    Integer getAgeAbstractDemo() {
        super.getNameAbstractDemo();
        return null;
    }

    @Override
    public String getNameInterfaceDemo() {
        return null;
    }

    @Override
    public void getName2InterfaceDemo() {

    }

    @Override
    public Integer getAgeInterfaceDemo() {
        return null;
    }
}
