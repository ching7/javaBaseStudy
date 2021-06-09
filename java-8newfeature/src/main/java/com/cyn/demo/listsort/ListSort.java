package com.cyn.demo.listsort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Description: 自定义list排序
 * @Author: ynchen9
 * @CreateTime: 2021-05-31
 */
public class ListSort {
    static List<Integer> intList = Arrays.asList(2, 5, 7, 3, 1);
    static List<Boolean> booleanList = Arrays.asList(true, false, false, true, true);

    public static void main(String[] args) {
//        sortIntList();
        sortBooleanList();

    }

    public static void sortIntList() {
        System.out.println("before sort:" + intList);
        System.out.println("=========================");
        Collections.sort(intList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 返回值为int类型，大于0表示正序，小于0表示逆序
                System.out.println("o2-o1:" + (o2 - o1) + "========o2=" + o2 + "o1=" + o1);
                if (o2 > o1) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        System.out.println("after sort:");
        System.out.println(intList);
    }

    public static void sortBooleanList() {
        System.out.println("before sort:" + booleanList);
        System.out.println("=========================");
        booleanList.sort((o1, o2) -> {
            // 返回值为int类型，大于0表示正序，小于0表示逆序
            System.out.println("o2=" + o2 + ",o1=" + o1);
            if (o1) {
                return -1;
            } else if (o2) {
                return 1;
            } else {
                return 0;
            }
        });
        System.out.println("after sort:");
        System.out.println(booleanList);
    }
}