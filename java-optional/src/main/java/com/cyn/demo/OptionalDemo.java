package com.cyn.demo;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/21
 */
public class OptionalDemo {
    public static void main(String[] args) {
        //withoutOptional();
        //withOptional();
        optionalTestMethod();
    }

    private static void optionalTestMethod() {
        // 1 创建 Optional 对象
        // 可以使用静态方法 empty() 创建一个空的 Optional 对象
        Optional<String> empty = Optional.empty();
        System.out.println(empty); // 输出：Optional.empty

        // 可以使用静态方法 of() 创建一个非空的 Optional 对象
        // 当然了，传递给 of() 方法的参数必须是非空的，也就是说不能为 null，否则仍然会抛出 NullPointerException。
        Optional<String> test = Optional.of("test");
        System.out.println(test);
       /* String name = null;
        Optional<String> optnull = Optional.of(name);*/

        // 可以使用静态方法 ofNullable() 创建一个即可空又可非空的 Optional 对象
        // String name = null;
        String name = "test";
        Optional<String> optOrNull = Optional.ofNullable(name);
        System.out.println(optOrNull); // 输出：Optional.empty

        // 2 判断值是否存在
        // 可以通过方法 isPresent() 判断一个 Optional 对象是否存在，如果存在，该方法返回 true，否则返回 false——取代了 obj != null 的判断。
        System.out.println(test.isPresent()); // 输出：true
        System.out.println(optOrNull.isPresent()); // 输出：true
        System.out.println(empty.isPresent()); // 输出：false

        // 3 非空表达式
        // Optional 类有一个非常现代化的方法——ifPresent()，允许我们使用函数式编程的方式执行一些代码，
        // 因此，我把它称为非空表达式。如果没有该方法的话，我们通常需要先通过 isPresent() 方法对 Optional 对象进行判空后再执行相应的代码：
        if (optOrNull.isPresent()) {
            System.out.println(optOrNull.get().length());
        }
        //Lambda
        optOrNull.ifPresent(str -> System.out.println(str.length()));

        //4 设置（获取）默认值
        // 有时候，我们在创建（获取） Optional 对象的时候，需要一个默认值，orElse() 和 orElseGet() 方法就派上用场了。
        // orElse() 方法用于返回包裹在 Optional 对象中的值，如果该值不为 null，则返回；否则返回默认值。该方法的参数类型和值得类型一致。
        String nullName = null;
        String nameT = Optional.ofNullable(nullName).orElse("cyn");
        System.out.println(nameT); // 输出：cyn
        // orElseGet() 方法与 orElse() 方法类似，但参数类型不同。如果 Optional 对象中的值为 null，则执行参数中的函数。
        String nameT1 = Optional.ofNullable(nullName).orElseGet(() -> "cyn1");
        System.out.println(nameT1); // 输出：cyn1
        // orElse() orElseGet() 区别 null时都走def，非空时，orElseGet不走def-性能更好
        String nameT2 = "cyn2";
        System.out.println("orElse");
        String name2 = Optional.ofNullable(nameT2).orElse(getDefaultValue());
        System.out.println(name2); // 输出：cyn2Def
        System.out.println("orElseGet");
        String name3 = Optional.ofNullable(nameT2).orElseGet(OptionalDemo::getDefaultValue);
        System.out.println(name3); // 输出：cyn2Def

        //5 获取值 optional为empty时，存在报错，建议 orElseGet() 方法获取 Optional 对象的值。
        // System.out.println(empty.get());

        //6 过滤值-用户注册时对密码的长度进行检查
        String password = "1234567";
        Optional<String> opt = Optional.ofNullable(password);
        System.out.println(opt.filter(pwd -> pwd.length() > 6).isPresent());

        //7 转化值 - 小写转化后，判断长度
        String password1 = "password";
        Optional<String> opt1 = Optional.ofNullable(password1);

        Predicate<String> len6 = pwd -> pwd.length() > 6;
        Predicate<String> len10 = pwd -> pwd.length() < 10;
        Predicate<String> eq = pwd -> pwd.equals("password");

        boolean result = opt1.map(String::toLowerCase).filter(len6.and(len10).and(eq)).isPresent();
        System.out.println(result);
    }

    public static String getDefaultValue() {
        System.out.println("getDefaultValue");
        return "cyn2Def";
    }

    public static void withOptional() {
        Optional<Member> optional = getMemberByIdFromDBWithOptional();
        optional.ifPresent(mem -> {
            System.out.println("会员姓名是：" + mem.getName());
        });
    }

    public static void withoutOptional() {
        Member mem = getMemberByIdFromDBWithOutOptional();
        if (mem != null) {
            System.out.println(mem.getName());
        }
    }

    public static Optional<Member> getMemberByIdFromDBWithOptional() {
        boolean hasName = true;
        if (hasName) {
            return Optional.of(new Member("沉默王二"));
        }
        return Optional.empty();
    }

    public static Member getMemberByIdFromDBWithOutOptional() {
        // 当前 ID 的会员不存在
        return null;
    }

    static class Member {
        private String name;

        public Member(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
