package com.cyn.demo.bean;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-06-07
 */
public class Man {
    //身份证号
    private String id;
    //姓名
    private String name;

    private String num;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Man{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", num='" + num + '\'' +
                '}';
    }
}

