package com.cyn.demo;

import com.cyn.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/15
 * <p>
 * java值传递问题
 */
public class CallByValue {
    public static void main(String[] args) {
        // callByValueDemo();
        int age = 200;
        changeValue1(age);
        System.out.println("===" + age);

        User user = new User();
        user.setName("cynMain");
        user.setGender("male");
        changeValue2(user);
        System.out.println("===" + user);

        String str = "cynxxxMain";
        changeValue3(str);
        System.out.println("===" + str);
    }

    public static void callByValueDemo() {
        CallByValue pt = new CallByValue();
        User hollis = new User();
        hollis.setName("Hollis");
        hollis.setGender("Male");
        pt.pass(hollis);
        System.out.println("print in main , user is " + hollis + " ,hashcode is" + hollis.hashCode());
    }

    public void pass(User user) {
/*        user.setName("hollischuang");
        System.out.println("print in pass , user is " + user + " ,hashcode is" + user.hashCode());*/

        user = new User();
        user.setName("hollischuang");
        System.out.println("print in pass , user is " + user + " ,hashcode is" + user.hashCode());
    }

    public static void changeValue1(int age) {
        age = 30;
    }

    public static void changeValue2(User user) {
        user.setName("cyn");
    }

    public static void changeValue3(String val) {
        val = "cynxxx";
    }
}
