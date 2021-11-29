package com.cyn.demo.generic.base;

import org.junit.Test;

/**
 * The type T generic method t.
 *
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021 -11-29
 */
public class TGenericMethodT {

    /**
     * T generic method t.
     *
     * @param <T>    the type parameter
     * @param tClass the t class
     * @return the t
     * @throws InstantiationException the instantiation exception
     * @throws IllegalAccessException the illegal access exception
     *                                * 说明：
     *                                *     1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     *                                *     2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     *                                *     3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     *                                *     4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
     */
    public <T> T TGenericMethod(Class<T> tClass) throws InstantiationException,
            IllegalAccessException {
        T instance = tClass.newInstance();
        return instance;
    }

    /**
     * 这才是一个真正的泛型方法。
     * 首先在public与返回值之间的<T>必不可少，这表明这是一个泛型方法，并且声明了一个泛型T
     * 这个T可以出现在这个泛型方法的任意位置.
     * 泛型的数量也可以为任意多个
     * 如：public <T,K> K showKeyName(Generic<T> container){
     * ...
     * }
     */
    public <T> T showKeyName(Generic<T> container) {
        System.out.println("container key :" + container.getKey());
        //当然这个例子举的不太合适，只是为了说明泛型方法的特性。
        T test = container.getKey();
        return test;
    }

    //这也不是一个泛型方法，这就是一个普通的方法，只是使用了Generic<Number>这个泛型类做形参而已。
    public void showKeyValue1(Generic<Number> obj) {
        System.out.println("泛型测试:key value is " + obj.getKey());
    }

    //这也不是一个泛型方法，这也是一个普通的方法，只不过使用了泛型通配符?
    //同时这也印证了泛型通配符章节所描述的，?是一种类型实参，可以看做为Number等所有类的父类
    public void showKeyValue2(Generic<?> obj) {
        System.out.println("泛型测试:key value is " + obj.getKey());
    }

    @Test
    public void t() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Object obj = TGenericMethod(Class.forName("com.cyn.demo.generic.base.TGenericWildcard"));

    }

    @Test
    public void t2() {
        Generic<String> generic = new Generic("123");
        String showKeyName = showKeyName(generic);
        System.out.println(showKeyName);
    }

}
