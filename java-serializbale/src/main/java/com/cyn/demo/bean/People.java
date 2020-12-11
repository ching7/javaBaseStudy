package com.cyn.demo.bean;

import java.io.*;

/**
 * 文件描述
 *
 * @ProjectName: java-serializbale
 * @Package: com.cyn.bean
 * @Date 2020/3/19 9:27
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class People implements Serializable {

    private static final long serialVersionUID = 3282215350418518214L;
    //private static final long serialVersionUID = 3282215350418518215L;

    private String name;
    private int age;

    public static String pre = "沉默";
    transient String meizi = "王三";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", meizi='" + meizi + '\'' +
                ", pre='" + pre + '\'' +
                '}';
    }

}
