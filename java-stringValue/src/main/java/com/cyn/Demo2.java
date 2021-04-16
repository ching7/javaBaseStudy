package com.cyn;

import java.util.Arrays;

/**
 * @author chenyanan
 * @date 2021/3/29
 * Created by chenyanan on 2021/3/29
 */
public class Demo2 {
    public static void main(String[] args) {
        String string = "ddd,ddd,www,dddd,222,eee";
        String[] split = string.split(",");
        System.out.println(Arrays.toString(split).replace(']',' ').replace('[',' ').trim());
        Arrays.stream(split).forEach(System.out::println);
    }
}
