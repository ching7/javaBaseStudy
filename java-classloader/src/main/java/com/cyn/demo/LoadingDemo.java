package com.cyn.demo;

/**
 * @author chenyanan
 * Created by chenyanan on 2021/1/19
 * <p>
 * 加载、验证、准备、解析、初始化、使用、卸载
 */
public class LoadingDemo {
    public static void main(String[] args) {
        int x = Son.count;
    }
}

class Dgrandpa {
    Dgrandpa() {
        System.out.println("init Dgrandpa structr");
    }

    static {
        System.out.println("init Dgrandpa");
    }
}

class Dfather extends Dgrandpa {
    static int count = 1;

    Dfather() {
        System.out.println("init Dfather structr");
    }

    static {
        System.out.println("init Dfather");
    }
}

class Son extends Dfather {
    Son() {
        System.out.println("init Son structr");
    }

    static {
        System.out.println("init son");
    }
}
