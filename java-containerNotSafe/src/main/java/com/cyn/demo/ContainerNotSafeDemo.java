package com.cyn.demo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/21
 * <p>
 * 集合安全问题
 */
public class ContainerNotSafeDemo {
    public static void main(String[] args) {
        // listNotSafe();
        // setNotSafe();
        // mapNotSafe();
        String chars = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0 ; i < 4; i++){
            System.out.println(Math.random() * 26);
            System.out.println(chars.charAt((int) (Math.random() * 26)));
        }
    }

    public static void mapNotSafe() {
        //Map<Object, Object> Map = new HashMap<>();
         Map<Object, Object> Map = new Hashtable<>();
        //Map<Object, Object> Map = new ConcurrentHashMap<>();
        // Map<Object, Object> Map = Collections.synchronizedMap(new HashMap<>());
        for (int i = 0; i < 40; i++) {
            int finalI = i;
            new Thread(() -> {
                Map.put(finalI, UUID.randomUUID().toString().substring(0, 8));
                System.out.println("===" + Map + " size：" + Map.size());
            }, String.valueOf(i)).start();
        }
        /** java.util.ConcurrentModificationException
         * 1 故障现象：java.util.ConcurrentModificationException
         * 2 原因
         *  并发修改导致。
         *  2.1 数组超长\数据丢失
         * 3 解决方案
         *  3.1 new Hashtable<>();
         *  3.2 Collections.synchronizedMap(new HashMap<>());
         *  3.3 new ConcurrentHashMap<>();
         */
    }

    public static void setNotSafe() {
        Set<String> set = new HashSet<>();
        // Set<String> set = Collections.synchronizedSet(new HashSet<>());
        // Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 40; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println("===" + set + " size：" + set.size());
            }, String.valueOf(i)).start();
        }
        /** java.util.ConcurrentModificationException
         * 1 故障现象：java.util.ConcurrentModificationException
         * 2 原因
         *  并发修改导致。
         *  2.1 数组超长\数据丢失
         * 3 解决方案
         *  3.2 Collections.synchronizedSet(new HashSet<>());
         *  3.3 new CopyOnWriteArraySet<>();
         */
    }

    public static void listNotSafe() {
        // List<String> list = new ArrayList<>();
        // List<String> list = new Vector<>();
        // List<String> list = Collections.synchronizedList(new ArrayList<>());
        CopyOnWriteArrayList<Object> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 40; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println("===" + list + " size：" + list.size());
            }, String.valueOf(i)).start();
        }
        /** java.util.ConcurrentModificationException
         * 1 故障现象：java.util.ConcurrentModificationException
         * 2 原因
         *  并发修改导致。
         *  2.1 数组超长\数据丢失
         * 3 解决方案
         *  3.1 vector List<String> list = new Vector<>(); 加锁synchronized,性能低
         *  3.2 Collections.synchronizedList(new ArrayList<>())
         *  3.3 new CopyOnWriteArrayList
         */
        // 4 优化
    }
}
