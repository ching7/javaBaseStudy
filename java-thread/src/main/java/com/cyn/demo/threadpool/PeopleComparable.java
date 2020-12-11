package com.cyn.demo.threadpool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 文件描述
 *
 * @ProjectName: java-threadcreate
 * @Package: com.cyn.threadpool
 * @Date 2020/4/21 19:42
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class PeopleComparable {
    public static void main(String[] args) {
        People people1 = new People(15, "五万1");
        People people2 = new People(125, "五万2");
        People people3 = new People(135, "五万3");
        List<People> list = new ArrayList<>();
        list.add(people3);
        list.add(people1);
        list.add(people2);
        Collections.sort(list);
        list.stream().forEach(e -> System.out.println(e.toString()));
    }
}
