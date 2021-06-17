package com.cyn.demo.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chenyanan
 * @date 2021/4/19
 * Created by chenyanan on 2021/4/19
 */
public class MapStream {

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("王二"));
        list.add(new User("李四"));
        List<User> collect = list.stream().peek(user -> {
            if (user.name == "王二") {
                user.name = "王三";
            }
        }).collect(Collectors.toList());
        collect.forEach(user -> {
            System.out.println(user);
        });
    }

    @Test
    public void  getAttribute4Obj(){
        List<User> list = new ArrayList<>();
        list.add(new User("王二"));
        list.add(new User("李四"));
        List<String> collect = list.stream().map(User::getName).collect(Collectors.toList());
        System.out.println(collect);
    }
}

class User {
    String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
