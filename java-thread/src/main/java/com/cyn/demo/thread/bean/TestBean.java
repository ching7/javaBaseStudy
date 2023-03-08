package com.cyn.demo.thread.bean;

/**
 * @author chenyanan
 */
public class TestBean {
    private String name;
    private int age = 0;

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

    public TestBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public TestBean() {
        this.name = "默认用户";
        this.age = 0;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
