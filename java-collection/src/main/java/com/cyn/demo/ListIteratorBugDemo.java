package com.cyn.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName ListIteratorBugDemo
 * @Description
 * @Author ynchen
 * @Date 2024/7/11 16:18
 * @Version V1.0.0
 */
public class ListIteratorBugDemo {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();

        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        Iterator<Integer> iterator = integerList.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next == 3){
                // 存在BUG
                integerList.remove(next);
            }
        }
        integerList.forEach(System.out::println);

    }
}
