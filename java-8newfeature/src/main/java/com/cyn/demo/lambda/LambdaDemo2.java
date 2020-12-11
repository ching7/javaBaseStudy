package com.cyn.demo.lambda;

import java.util.Arrays;

/**
 * 文件描述
 *
 * @ProjectName: java-8newfeature
 * @Package: com.cyn.lambda
 * @Date 2020/5/9 16:27
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class LambdaDemo2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        Arrays.stream(nums).forEach(value -> System.out.println(value));
    }
}
