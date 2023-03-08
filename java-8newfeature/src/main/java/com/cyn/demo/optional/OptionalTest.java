package com.cyn.demo.optional;

import com.cyn.demo.bean.Man;
import com.cyn.demo.bean.User;
import org.junit.Test;

import java.util.Optional;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-11-26
 */
public class OptionalTest {
    @Test
    public void baseTest() {
        Integer value1 = null;
        Integer value2 = 10;

        // Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> a = Optional.ofNullable(value1);

        // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
        Optional<Integer> b = Optional.of(value2);
        System.out.println(sum(a, b));
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b) {

        // Optional.isPresent - 判断值是否存在

        System.out.println("第一个参数值存在: " + a.isPresent());
        System.out.println("第二个参数值存在: " + b.isPresent());

        // Optional.orElse - 如果值存在，返回它，否则返回默认值
        Integer value1 = a.orElse(0);

        //Optional.get - 获取值，值需要存在
        Integer value2 = b.get();
        return value1 + value2;
    }

    @Test
    public void baseTest2() throws Exception {
        int id = 1;
        /**
         * 如果 Optional 中有值，则对该值调用 consumer.accept，否则什么也不做。
         * 所以对于上面的例子，我们可以修改为：
         */
        Optional<User> user = Optional.ofNullable(getUserById(id));
        user.ifPresent(u -> System.out.println("Username is: " + u.getUserName()));

        /**
         * 如果 Optional 中有值则将其返回，否则返回 orElse 方法传入的参数。
         */
        User user1 = Optional
                .ofNullable(getUserById(id))
                .orElse(new User(0, "Unknown1"));

        System.out.println("Username is: " + user1.getUserName());

        /**
         * orElseGet 与 orElse 方法的区别在于，orElseGet 方法传入的参数为一个 Supplier 接口的实现
         * —— 当 Optional 中有值的时候，返回值；当 Optional 中没有值的时候，返回从该 Supplier 获得的值。
         */
        User user2 = Optional
                .ofNullable(getUserById(id))
                .orElseGet(() -> new User(0, "Unknown2"));
        System.out.println("Username is: " + user2.getUserName());

        /**
         * orElseThrow 与 orElse 方法的区别在于，
         * orElseThrow 方法当 Optional 中有值的时候，返回值；
         * 没有值的时候会抛出异常，抛出的异常由传入的 exceptionSupplier 提供
         */
//        User user3 = Optional
//                .ofNullable(getUserById(id))
//                .orElseThrow(() -> new Exception("id 为 " + id + " 的用户没有找到"));


        /**
         * 如果当前 Optional 为 Optional.empty，则依旧返回 Optional.empty；
         * 否则返回一个新的 Optional，该 Optional 包含的是：函数 mapper 在以 value 作为输入时的输出值
         */
        Optional<String> username = Optional
                .ofNullable(getUserById(id))
                .map(user4 -> user4.getUserName());

        System.out.println("Username is: " + username.orElse("Unknown4"));

        /**
         * 多次map
         */
        Optional<String> username2 = Optional
                .ofNullable(getUserById(id))
                .map(user5 -> user5.getUserName())
                .map(name -> name.toLowerCase())
                .map(name -> name.replace('_', ' '));

        System.out.println("Username is: " + username2.orElse("Unknown5"));


        /**
         * flatMap 方法与 map 方法的区别在于，
         * map 方法参数中的函数 mapper 输出的是值，然后 map 方法会使用 Optional.ofNullable 将其包装为 Optional；
         * 而 flatMap 要求参数中的函数 mapper 输出的就是 Optional。
         */
        Optional<String> username3 = Optional
                .ofNullable(getUserById(id))
                .flatMap(user6 -> Optional.of(user6.getUserName()))
                .flatMap(name -> Optional.of(name.toLowerCase()));

        System.out.println("Username is: " + username3.orElse("Unknown6"));

        /**
         * filter 方法接受一个 Predicate 来对 Optional 中包含的值进行过滤，
         * 如果包含的值满足条件，那么还是返回这个 Optional；否则返回 Optional.empty
         */
        Optional<String> username4 = Optional
                .ofNullable(getUserById(id))
                .filter(user7 -> user7.getAge() < 10)
                .map(user7 -> user7.getUserName());

        System.out.println("Username is: " + username4.orElse("Unknown7"));
    }

    private User getUserById(int id) {
        User user = new User(20, "lisi");
        return user;
    }

    @Test
    public void test3() {
        Optional<User> user = Optional.ofNullable(getUserById(1));
        user.ifPresent(u -> System.out.println("Username is: " + u.getUserName()));
    }
}
