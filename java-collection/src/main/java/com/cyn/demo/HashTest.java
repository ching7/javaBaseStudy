package com.cyn.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

        HashMap<String,List<String>> ht = new HashMap<String, List<String>>();
        ht.put("1", Arrays.asList("11","12"));
        ht.put("2", Arrays.asList("21","22"));
        ht.put("3", Arrays.asList("31","32"));
        ht.put("4", Arrays.asList("41","42"));

        ht.entrySet();
    }
}
