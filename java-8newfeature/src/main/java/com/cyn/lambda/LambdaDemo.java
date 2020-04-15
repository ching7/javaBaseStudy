package com.cyn.lambda;

/**
 * 文件描述
 *
 * @ProjectName: java-8newfeature
 * @Package: com.cyn.lambda
 * @Date 2020/4/15 9:34
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: 1、语法
 * (parameters) -> expression
 * 或
 * (parameters) ->{ statements; }
 * 2、特性
 * 可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
 * 可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
 * 可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
 * 可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值
 **/
public class LambdaDemo {
    /**
     * 1. 不需要参数,返回值为 5
     * () -> 5
     */
    static GreetingService greetingService = () -> 5;


    /**
     * 2. 接收一个参数(数字类型),返回其2倍的值
     * x -> 2 * x
     *
     * @param s
     */
    static MathOperation2 mathOperation2 = (a) -> 2 * a;

    /**
     * 3. 接受2个参数(数字),并返回他们的差值
     * (x, y) -> x – y
     *
     * @param s
     */
    static MathOperation mathOperation = (a, b) -> a + b;

    /**
     * 4. 接收2个int型整数,返回他们的和
     * (int x, int y) -> x + y
     *
     * @param s
     */
    static MathOperation mathOperation3 = (int s1, int m1) -> s1 + m1;

    /**
     * 5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void)
     * (String s) -> System.out.print(s);
     *
     * @param s
     */
    static GreetingService2 greetingService2 = (String s) -> System.out.println(s);

    interface MathOperation {
        int operation(int a, int b);
    }

    interface MathOperation2 {
        int operation(int a);
    }

    interface GreetingService {
        int sayMessage();
    }

    interface GreetingService2 {
        void sayMessage(String msg);
    }

    public static void main(String[] args) {
        int res1 = greetingService.sayMessage();
        System.out.println("特性1 输出 " + res1);
        int res2 = mathOperation2.operation(2);
        System.out.println("特性2 输出 " + res2);
        int res3 = mathOperation.operation(2, 3);
        System.out.println("特性3 输出 " + res3);
        int res4 = mathOperation3.operation(4, 5);
        System.out.println("特性4 输出 " + res4);
        greetingService2.sayMessage("test");
    }
}
