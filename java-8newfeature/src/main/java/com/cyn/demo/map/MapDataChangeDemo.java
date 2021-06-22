package com.cyn.demo.map;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-06-18
 */
public class MapDataChangeDemo {
    @Test
    public void t() {
        Map<String, Map<String, Object>> callDataMap = Maps.newHashMap();
        Map<String, Object> callDataMap1 = Maps.newHashMap();
        callDataMap1.put("callCount", 1);
        callDataMap1.put("callCounts", 11);

        callDataMap.put("1", callDataMap1);

        Map<String, Object> callDataMap2 = Maps.newHashMap();
        callDataMap2.put("callCount", 2);
        callDataMap2.put("callCounts", 21);

        callDataMap.put("2", callDataMap2);

//        for (int i = 0; i < 5; i++) {
//            callDataMap.get("1").put("callCount1", (int) callDataMap.get("1").get("callCount1") + i);
//        }

        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        numberFormat.setMinimumFractionDigits(2);
        callDataMap.forEach((dataTime, data) -> {
            if ((int) data.get("callCount") != 0) {
                double callCounts = Double.parseDouble(data.get("callCounts").toString());
                double callCount = Double.parseDouble(data.get("callCount").toString());
                String callCountSuccessRate = numberFormat.format(callCount / callCounts);
                data.put("callCountSuccessRate", callCountSuccessRate);
            }
        });
        callDataMap.forEach((s, o) -> System.out.println("key:" + s + " value:" + o));
    }

    @Test
    public void maxValueInMap() {
        Map<Object, Object> map = new HashMap<>();
        map.put("2", 5);
        map.put("47", 2);
        map.put("13", 28);
        map.put("25", 17);
        int length = map.size();
        Collection<Object> c = map.values();
        Object[] obj = c.toArray();
        Arrays.sort(obj);
        System.out.println(Arrays.toString(obj));

    }

    @Test
    public void maxValueAndKey() {
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 8);
        map.put("2", 12);
        map.put("3", 53);
        map.put("4", 33);
        map.put("5", 11);
        map.put("6", 3);
        map.put("7", 3);
        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        //保留到小数点后2位,不设置或者设置为0表示不保留小数
        numberFormat.setMinimumFractionDigits(2);
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> (o2.getValue() - o1.getValue()));
        numberFormat.format(list.get(1).getValue() / list.get(0).getValue());
        System.out.println(list);

        System.out.println(numberFormat.format((double)list.get(1).getValue() / (double)list.get(0).getValue()));

    }
}
