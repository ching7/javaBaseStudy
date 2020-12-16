package com.cyn.demo.singleton;

import com.cyn.demo.singleton.demo.CommandBean;

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
        // DCL单例
        DclSingleton dclSingleton = DclSingleton.getInstance();
        dclSingleton.putMessage();
        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        enumSingleton.whateverMethod();

        //枚举
        ColorEnum green = GREEN;
        green.getName();

        //枚举单例测试
        EnumSingleton enumSingleton2 = EnumSingleton.INSTANCE;
        CommandBean instance2 = enumSingleton2.getInstance();

        EnumSingleton enumSingleton3 = EnumSingleton.INSTANCE;
        CommandBean instance3 = enumSingleton3.getInstance();
        System.out.println(instance2.hashCode());
        System.out.println(instance3.hashCode());
    }
}
