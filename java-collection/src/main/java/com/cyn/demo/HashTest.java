package com.cyn.demo;

import java.util.*;

/**
 * @ClassName HashTest
 * @Description
 * @Author ynchen
 * @Date 2023/11/18 10:19
 * @Version V1.0.0
 */
public class HashTest {
    public static void main(String[] args) {
        int t = "2".hashCode();
        System.out.println(t);
        ArrayList<String> objects = new ArrayList<>(null);
        objects.forEach(System.out::println);
        HashMap<String, List<String>> ht = new HashMap<String, List<String>>();
//        ht.put("1", Arrays.asList("11","12"));
//        ht.put("2", Arrays.asList("21","22"));
        ht.put("3", Collections.emptyList());
//        ht.put("4", Arrays.asList("41","42"));
        List<String> fs = new ArrayList<>();
        ht.forEach((s, ss) -> {
            if (!ss.isEmpty()) {
                fs.addAll(ss);
            }
        });
        boolean empty =  fs.isEmpty();
        System.out.println(empty);
    }
}
