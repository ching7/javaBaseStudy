package com.cyn.demo.generic.base;

import org.junit.Test;

/**
 * The type T generic wildcard.
 *
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021 -11-29
 */
public class TGenericWildcard {
    /**
     * Show key value 1.
     *
     * @param obj the obj
     */
    public void showKeyValue1(Generic<Number> obj) {
        System.out.println("key value is " + obj.getKey());

    }

    public void showKeyValue2(Generic<?> obj) {
        // 类型通配符一般是使用？代替具体的类型实参
        //？是类型实参，而不是类型形参
        //此处的？和Number、String、Integer一样都是一种实际的类型，可以把？看成所有类型的父类。是一种真实的类型。
        System.out.println("key value is " + obj.getKey());
    }

    @Test
    public void t() {
        Generic<Integer> gInteger = new Generic<Integer>(123);
        Generic<Number> gNumber = new Generic<Number>(456);
        //Generic<Integer>不能被看作为`Generic<Number>的子类。
        // 由此可以看出:同一种泛型可以对应多个版本（因为参数类型是不确定的），不同版本的泛型类实例是不兼容的。
        // showKeyValue1(gInteger);
        showKeyValue1(gNumber);
        showKeyValue2(gInteger);
    }
}
