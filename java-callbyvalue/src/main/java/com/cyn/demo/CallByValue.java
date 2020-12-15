package com.cyn.demo;

import com.cyn.bean.User;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/15
 */
public class CallByValue {
    public static void main(String[] args) {
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
}
