package com.cyn.singleton;

/**
 * 文件描述
 *
 * @ProjectName: java-design-pattern
 * @Package: com.cyn.singleton
 * @Date 2020/4/14 19:25
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description:
 *
 * 枚举类
 * 1、构造方法默认是private
 **/
public enum ColorEnum {
    /**
     *
     */
    RED("红色", "1",123),
    GREEN("绿色", "2",2),
    BLANK("白色", "3",3),
    YELLO("黄色", "4",4);
    /**
     * 成员变量
     */
    private String name;
    private String index;
    private int isndex;

    private ColorEnum(String name, String index, int isndex) {
        this.name = name;
        this.index = index;
        this.isndex = isndex;
    }

    @Override
    public String toString() {
        return "ColorEnum{" +
                "name='" + name + '\'' +
                ", index='" + index + '\'' +
                ", isndex=" + isndex +
                '}';
    }
}
