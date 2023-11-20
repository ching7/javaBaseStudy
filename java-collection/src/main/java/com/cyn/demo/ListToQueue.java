package com.cyn.demo;

import java.util.*;

/**
 * @ClassName ListToQueue
 * @Description
 * @Author ynchen
 * @Date 2023/11/14 17:12
 * @Version V1.0.0
 */
public class ListToQueue {
    public static void main(String[] args) {
        List<Integer> sqLockResList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            sqLockResList.add(i);
        }
        Queue<Integer> sqLockQueue = new LinkedList<>(sqLockResList);
        for (Integer integer : sqLockQueue) {
            System.out.println(integer);

        }
//        for (int i = 0; i < sqLockQueue.size(); i++) {
//                        System.out.println(sqLockQueue.poll());
//
//        }

    }
}