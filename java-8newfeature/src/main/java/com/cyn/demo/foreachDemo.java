package com.cyn.demo;

import java.util.Arrays;

/**
 * @author chenyanan
 * @date 2021/4/16
 * Created by chenyanan on 2021/4/16
 */
public class foreachDemo {
    public static void main(String[] args) {
        String[] strings = {"1", "2", "3"};
        Arrays.stream(strings).forEach(s -> {
            if (s.equals("2")) {
                return;
            }
            System.out.println("===" + s);
        });
        System.out.println("===");

        //
        for (String string : strings) {
            if (string.equals("2")) {
                return;
            }
            System.out.println("===" + string);
        }
    }
}
