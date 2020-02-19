package com.cyn.bean;

/**
 * 文件描述
 *
 * @ProjectName: java-reflect
 * @Package: com.cyn.bean
 * @Description: note
 * @CreateDate: 2019/9/25 19:58
 * @UpdateDate: 2019/9/25 19:58
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 **/
@Deprecated
public class People {
    private String name;
    private int age;

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
                '}';
    }
}
