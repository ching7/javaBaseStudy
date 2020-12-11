package com.cyn.demo.singleton;

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
    }
}
