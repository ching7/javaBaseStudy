package com.cyn.demo.extend;

/**
 * @author chenyanan
 * @date 2021/3/30
 * Created by chenyanan on 2021/3/30
 * 假如你的A是一个接口，或者抽象类，那么是不可以创建对象的，这样写就可以也能够它的引用去指向他子类或者实现类的对象。这句话写在这里感觉不明显。
 * 其实主要是用在方法的参数上，也就是多态性（java的三大特性之一，可想何等重要），为了让你理解深刻，我举个例子。
 * 假如有一个类，这个类需要实现吃各种水果，有香蕉，苹果，梨子等等。
 * 我们是不是就得写:
 * public  void eat(Banana banana) { //.....}
 * public  void eat(Apple apple) { //.....}
 * 等等等等。这样是不是很麻烦啊，但是我要是把这个方法写成:
 * public void eat(Fruit fruit){//....}
 * 这样只要继承Fruit或者实现Fruit接口，就都可以作为eat的参数，是不是大大简化了编程。
 */
public class TestMain {
    public static void main(String[] args) {
        // 父类引用指向子类
        // 父类声明子类实例化
        Parent01 parent01 = new Child01();
        System.out.println(parent01.getParentName());

        InterFaceParent01 interFaceParent01 = new Child02();
        System.out.println(interFaceParent01.getName());
    }
}
