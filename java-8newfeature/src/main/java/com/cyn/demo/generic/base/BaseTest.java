package com.cyn.demo.generic.base;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 泛型有三种使用方式，分别为：泛型类、泛型接口、泛型方法
 * @Author: ynchen9
 * @CreateTime: 2021-11-29
 */
public class BaseTest {
    @Test
    public void tGeneric() {
        // 泛型例子
//        List arrayList = new ArrayList();
//        arrayList.add("aaaa");
//        arrayList.add(100);
//
//        for (int i = 0; i < arrayList.size(); i++) {
//            String item = (String) arrayList.get(i);
//            System.out.println(item);
//        }

        // 编译时期的泛型生效
        List<String> stringArrayList = new ArrayList<>();
        List<Integer> integerArrayList = new ArrayList<>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        if (classStringArrayList.equals(classIntegerArrayList)) {
            System.out.println("泛型测试-类型相同");
        }
    }

    @Test
    public void tGenericInterface() {
        TGenericInterface<String> tGenericInterface = new TGenericImpl();
        String next = tGenericInterface.next();
        System.out.println(next);
    }

}
