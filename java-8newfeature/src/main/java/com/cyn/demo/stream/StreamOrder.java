package com.cyn.demo.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-10-21
 */
public class StreamOrder {
    @Test
    public void testOrderStream() {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            strings.add(String.valueOf(i));
        }
        strings = strings.stream().filter(s -> {
            if (s.equals("3") || s.equals("4")) {
                return true;
            } else {
                return false;
            }
        }).collect(Collectors.toList());
        strings.forEach(System.out::println);
    }
}
