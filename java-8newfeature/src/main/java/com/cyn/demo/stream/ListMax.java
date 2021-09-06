package com.cyn.demo.stream;

import com.cyn.demo.bean.Man;
import org.junit.Test;
import sun.management.Sensor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-09-06
 */
public class ListMax {
    @Test
    public void test() {
        List<Man> sensorMongoList = new ArrayList<>();
        Man sensor = new Man();
        sensor.setId("123123");
        sensor.setNum("1");
        sensorMongoList.add(sensor);

        Man sensorTwo = new Man();
        sensorTwo.setId("3423423");
        sensorTwo.setNum("2");
        sensorMongoList.add(sensorTwo);

        Man sensor1 = sensorMongoList.stream().max(Comparator.comparing(Man::getNum)).get();
        String num = sensor1.getNum();
        num = String.valueOf(Integer.parseInt(num) + 1);
        System.err.println(num);

    }


    @Test
    public void changeStr() {
        String a = "3";
        Integer b = 3;
        Man m = new Man();
        m.setNum("3");
        String testChangeField = testChangeField(a, b, m);
        System.out.println(a);
        System.out.println(b);
        System.out.println(m);

    }

    public String testChangeField(String t, Integer b, Man m) {
        t = t + ";test";
        b = b + 1;
        m.setNum("4");
        return t + ";test";
    }
}
