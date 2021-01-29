package com.cyn.demo.bean;

/**
 * @author chenyanan
 * @date 2021/1/28
 * Created by chenyanan on 2021/1/28
 */
public class People {
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public People(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
