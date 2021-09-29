package com.cyn.demo.map;

import java.util.*;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-06-22
 */
public class SortMap {
    public static void main(String[] args) {
        Map<String, Long> map = new HashMap();
        map.put("k", 1L);
        map.put("k3", 3L);
        map.put("k2", 2L);

        LinkedHashMap<String, Long> stringStringMap = sortByValue(map, false);
        Set<String> strings = stringStringMap.keySet();
        List<String> k = new ArrayList<>(strings);

        System.out.println(k.get(0));
        System.out.println(1L/1L);
    }

    /**
     * map对key进行排序
     *
     * @param map
     * @param asc
     * @return
     */
    private static <K extends Comparable<? super K>, V> Map<K, V> sortByKey(
            Map<K, V> map, boolean asc) {
        Map<K, V> result = new LinkedHashMap<>();
        Stream<Map.Entry<K, V>> stream = map.entrySet().stream();
        if (asc) {
            stream.sorted(Map.Entry.comparingByKey()).forEachOrdered(
                    e -> result.put(e.getKey(), e.getValue()));
        } else {
            stream.sorted(Map.Entry.<K, V>comparingByKey().reversed())
                    .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        }
        return result;
    }

    /**
     * map对value进行排序
     *
     * @param map
     * @return
     */
    private static <K, V extends Comparable<? super V>> LinkedHashMap<K, V> sortByValue(Map<K, V> map, boolean asc) {
        LinkedHashMap<K, V> result = new LinkedHashMap<>();
        Stream<Map.Entry<K, V>> stream = map.entrySet().stream();
        if (asc) //升序
        {
            stream.sorted(Map.Entry.comparingByValue()).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        } else //降序
        {
            stream.sorted(Map.Entry.<K, V>comparingByValue().reversed()).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        }
        return result;
    }

    public static <K, V extends Comparable<? super V>> LinkedHashMap<K, V> sortByValue2(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        LinkedHashMap<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

}