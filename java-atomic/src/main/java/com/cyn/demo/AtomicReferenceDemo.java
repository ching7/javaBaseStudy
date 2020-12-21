package com.cyn.demo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/21
 */
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User u1 = new User("123", 22);
        User u2 = new User("345", 44);
        AtomicReference<User> atomicReference = new AtomicReference<User>();
        atomicReference.set(u1);

        System.out.println("===" + atomicReference.compareAndSet(u1, u2) + "\t " + atomicReference.get().toString());
        System.out.println("===" + atomicReference.compareAndSet(u1, u2) + "\t " + atomicReference.get().toString());

    }
}

@Getter
@ToString
@AllArgsConstructor
class User {
    String userName;
    int age;
}

