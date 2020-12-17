package com.cyn.demo;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/17
 */
public class T1 {

    public static void main(String[] args) {
        add();
    }

    public static void add() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        LinkedList<Integer> objects = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(i);
        }
        Arrays.stream(arr).parallel().forEach(value -> {
            System.out.println(value);
        });
        System.out.println("===");
        objects.forEach(val -> {
            System.out.println(val);
        });
        System.out.println("===");

        objects.parallelStream().forEach(val -> {
            System.out.println(val);
        });
        System.out.println("===");

    }
}
