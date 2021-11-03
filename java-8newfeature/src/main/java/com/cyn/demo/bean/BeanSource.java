package com.cyn.demo.bean;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-11-03
 */
public class BeanSource implements Cloneable {
    private String name;
    private String age;

    public BeanSource(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "BeanSource{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
