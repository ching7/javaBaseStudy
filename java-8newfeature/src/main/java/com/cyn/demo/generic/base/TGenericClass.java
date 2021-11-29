package com.cyn.demo.generic.base;

import org.junit.Test;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-11-29
 */
public class TGenericClass {
    // 泛型类


    @Test
    public void tGenericClass() {

        //泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
        //传入的实参类型需与泛型的类型参数类型相同，即为Integer.
        Generic<Integer> genericInteger = new Generic<Integer>(123456);

        //传入的实参类型需与泛型的类型参数类型相同，即为String.
        Generic<String> genericString = new Generic<String>("key_vlaue");
        System.out.println("泛型测试 key is " + genericInteger.getKey());
        System.out.println("泛型测试 key is " + genericString.getKey());

        Generic generic = new Generic("111111");
        Generic generic1 = new Generic(4444);
        Generic generic2 = new Generic(55.55);
        Generic generic3 = new Generic(false);

        System.out.println("泛型测试key is " + generic.getKey());
        System.out.println("泛型测试key is " + generic1.getKey());
        System.out.println("泛型测试key is " + generic2.getKey());
        System.out.println("泛型测试key is " + generic3.getKey());
        System.out.println("泛型测试key type is " + generic.getKey().getClass().getTypeName());
        System.out.println("泛型测试key type is " + generic1.getKey().getClass().getTypeName());
        System.out.println("泛型测试key type is " + generic2.getKey().getClass().getTypeName());
        System.out.println("泛型测试key type is " + generic3.getKey().getClass().getTypeName());
    }
}
