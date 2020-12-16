package com.cyn.demo.singleton;

import static com.cyn.demo.singleton.ColorEnum.GREEN;

/**
 * 文件描述
 *
 * @ProjectName: javaBaseStudy
 * @Package: com.cyn.singleton
 * @Date 2020/4/14 18:41
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class SingleDemo {
    public static void main(String[] args) {
        //DclSingleton dclSingleton = new DclSingleton();
        DclSingleton dclSingleton = DclSingleton.getInstance();
        dclSingleton.putMessage();
        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        enumSingleton.whateverMethod();

        //枚举
        ColorEnum green = GREEN;
        green.getName();
    }
}
