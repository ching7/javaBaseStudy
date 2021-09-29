package com.cyn.demo.listsort;

import com.cyn.demo.bean.People;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description: 自定义list排序
 * @Author: ynchen9
 * @CreateTime: 2021-05-31
 */
public class ListSort {
    static List<Integer> intList = Arrays.asList(2, 5, 7, 3, 1);
    static List<Boolean> booleanList = Arrays.asList(true, false, false, true, true);

    public static void main(String[] args) {
        sortIntList();
        //   sortBooleanList();

    }

    public static void sortIntList() {
        System.out.println("before sort:" + intList);
        System.out.println("=========================");
        Collections.sort(intList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 返回值为int类型，大于0表示正序，小于0表示逆序
                // System.out.println("o2-o1:" + (o2 - o1) + "========o2=" + o2 + "o1=" + o1);
                // 升序
                return o1.compareTo(o2);
                // 倒序
                // return o2.compareTo(o1);

//                if (o1 > o2) {
//                    return 1;
//                } else if (o1 < o2) {
//                    return -1;
//                } else {
//                    return 0;
//                }
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

    @Test
    public void testFor() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("123");
        arrayList.add("124");
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.set(i, arrayList.get(i) + "1");
        }
        arrayList.forEach(System.out::println);
    }

    @Test
    public void sortObj() {
        People peoplea = new People("A", 123);
        People peopleb = new People("b", 321);
        List<People> peopleList
                = new ArrayList<>();
        peopleList.add(peoplea);
        peopleList.add(peopleb);
        // Comparator.comparing 默认为升序
        peopleList = peopleList.stream().sorted(Comparator.comparing(People::getAge)).collect(Collectors.toList());

        peopleList = peopleList.stream().sorted((o1, o2) -> o2.getAge().compareTo(o1.getAge())).collect(Collectors.toList());
        System.out.println(peopleList);
    }
}
