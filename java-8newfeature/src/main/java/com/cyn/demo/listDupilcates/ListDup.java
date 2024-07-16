package com.cyn.demo.listDupilcates;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName ListDup
 * @Description
 * @Author ynchen
 * @Date 2024/7/12 11:25
 * @Version V1.0.0
 */
public class ListDup {
    @Test
    public void m1() {
        List<Integer> integerList = Arrays.asList(70, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
        List<Integer> srcList = new ArrayList<>();
        for (Integer integer : integerList) {
            if (!srcList.contains(integer)) {
                srcList.add(integer);
            }
        }
        System.out.println(srcList);
    }

    @Test
    public void m2() {
        List<Integer> integerList = Arrays.asList(70, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
        Set<Integer> destList = new HashSet<>(integerList);
        System.out.println(destList);
    }

    @Test
    public void m3() {
        List<Integer> integerList = Arrays.asList(70, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
        // 无序
        Set<Integer> destList = new HashSet<>(integerList);
        System.out.println(destList);
        // 有序
        Set<Integer> destList2 = new LinkedHashSet<>(integerList);
        System.out.println(destList2);

    }

    @Test
    public void m4() {
        List<Integer> integerList = Arrays.asList(70, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
        List<Integer> collect = integerList.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void m5() {
        List<Integer> integerList = Arrays.asList(70, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
        List<Integer> collect = new ArrayList<>(integerList);
        List<Integer> newCollects = new ArrayList<>(integerList);
        for (Integer i : collect) {
            if (newCollects.indexOf(i) != newCollects.lastIndexOf(i)) {
                newCollects.remove(newCollects.indexOf(i));
            }
        }
        System.out.println(newCollects);
    }

    @Test
    public void m6() {
        List<Integer> integerList = Arrays.asList(70, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
        List<Integer> collect = new ArrayList<>(integerList);
        for (int i = 0; i < collect.size() - 1; i++) {
            for (int j = collect.size() - 1; j > i; j--) {
                if (collect.get(j).equals(collect.get(i))) {
                    collect.remove(j);
                }
            }
        }
        System.out.println(collect);
    }
}
