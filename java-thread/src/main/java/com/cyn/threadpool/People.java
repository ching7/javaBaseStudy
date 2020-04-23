package com.cyn.threadpool;

/**
 * 文件描述
 *
 * @ProjectName: java-threadcreate
 * @Package: com.cyn.threadpool
 * @Date 2020/4/21 19:39
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class People implements Comparable<People> {
    private int age;
    private String name;

    @Override
    public String toString() {
        return "People{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public People(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(People o) {
        return this.age - o.age;
    }
}
