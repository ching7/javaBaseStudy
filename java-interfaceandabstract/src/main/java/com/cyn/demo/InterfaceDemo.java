package com.cyn.demo;

/**
 * @author chenyanan
 * Created by chenyanan on 2021/1/21
 */
public interface InterfaceDemo {
    public static final String tName = "12";

    public static void getInit() {
        System.out.println("InterfaceDemo getInit and tName = " + tName);
    }

    /**
     * @return
     */
    String getNameInterfaceDemo();

    abstract void getName2InterfaceDemo();

    /**
     * @return
     */
    Integer getAgeInterfaceDemo();
}
