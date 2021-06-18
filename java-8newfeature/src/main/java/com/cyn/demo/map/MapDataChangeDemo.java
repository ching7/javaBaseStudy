package com.cyn.demo.map;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;

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
                String callCountSuccessRate = numberFormat.format( callCount/ callCounts);
                data.put("callCountSuccessRate", callCountSuccessRate);
            }
        });
        callDataMap.forEach((s, o) -> System.out.println("key:" + s + " value:" + o));
    }
}
