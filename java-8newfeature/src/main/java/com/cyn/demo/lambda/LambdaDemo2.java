package com.cyn.demo.lambda;

import cn.hutool.json.JSONString;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cyn.demo.bean.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
//        Arrays.stream(nums).forEach(value -> System.out.println(value));

        for (int i :
                nums) {
            if (i == 2) {
                break;
//                return;
//                continue;
            }
            System.out.println(i);
        }
        System.out.println("return");
    }

    @Test
    public void test() {
        String string = "{\"DICS-orgCode\":\"xhwei3\",\"ASR\":\"appid1;token1;ability1\",\"TTS\":\"appid2;token2;ability2\",\"NLP\":\"appid3;token3;ability3\"}";
        Map extendOrgCodeObj = JSONObject.parseObject(string, Map.class);
        extendOrgCodeObj.put("ACD-orgCode", "aiccdev");
        System.out.println(JSON.toJSONString(extendOrgCodeObj));
    }

    @Test
    public void test2() {
        List<User> lst = new ArrayList<>();
        lst.add(new User(1, "wanger"));
        lst.add(new User(2, "lisi"));
        // 根据坐席号获取坐席角色
        lst.stream().forEach(
                user -> {
                    if (null != user) {
                        user.setUserName(user.getUserName() + "1");
                    }
                });
        lst.stream().forEach(System.out::println);
    }
}
