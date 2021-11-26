package com.cyn.demo.bean;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-11-26
 */
public class User {
    private int age;
    private String userName;

    public User(int age, String userName) {
        this.age = age;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
