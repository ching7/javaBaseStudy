package com.cyn.demo.stringDemo;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.MD5;
import com.alibaba.fastjson.JSONArray;
import com.cyn.demo.bean.People;
import com.google.common.base.Joiner;
import org.junit.Test;

import java.util.*;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-09-13
 */
public class StringDemo {

    @Test
    public void testStringReplace() {
        String t = "aicc:acd:seat:seat_queue_10086_normal";
        String s = t.replaceFirst("aicc:acd:seat:", "aicc:acd:seat:bak_");
        MD5 md5 = new MD5();
        String s1 = md5.digestHex(t);
        System.out.println(s);
    }

    @Test
    public void testString() {
        String t = "['10086','10087','10088']";
        JSONArray jsonArray = JSONArray.parseArray(t);
        for (int i = 0; i < 10; i++) {
            System.out.println(RandomUtil.randomInt(0, jsonArray.size()));
        }
    }

    @Test
    public void testString2() {
        String t = "['847d97862a3c4bc6beebf7cefef01085','1d4d169203984ffc9e9a6984e2371ce6']";
        Object parse = JSONArray.parse(t);
        System.out.println(t);

        // String t1 = "847d97862a3c4bc6beebf7cefef01085,1d4d169203984ffc9e9a6984e2371ce6";
        String t1 = "847d97862a3c4bc6beebf7cefef010856";
        String[] split = t1.split(",");
        List<String> strings = Arrays.asList(split);
        String s22 = strings.get(0);
        System.out.println(s22);
        System.out.println(strings);
    }

    @Test
    public void testString3() {
//        String t1 = "847d97862a3c4bc6beebf7cefef01085,1d4d169203984ffc9e9a6984e2371ce6";
//        // String t1 = "847d97862a3c4bc6beebf7cefef010856";
//        String[] split = t1.split(",");
//        List<String> strings = Arrays.asList(t1);
//        String s22 = strings.get(0);
//        System.out.println(s22);
//        System.out.println(strings);
        List<String> strings = new ArrayList<>();
        strings.add("847d97862a3c4bc6beebf7cefef01085");
        strings.add("1d4d169203984ffc9e9a6984e2371ce6");
        System.out.println(strings.toString());
        People p = new People("1", 1);
        System.out.println(p.getAge() + 1);
    }
    @Test
    public void testString4() {
        List<String> strings = new ArrayList<>();
        strings.add("847d97862a3c4bc6beebf7cefef01085");
        strings.add("1d4d169203984ffc9e9a6984e2371ce6");
        String join = String.join(",", strings);
        String join1 = Joiner.on("|").join(strings);
        System.out.println(join);
        System.out.println(join1);
    }

    @Test
    public void dateToString() {
        Date date = new Date();
        System.out.println(date);
    }
}
