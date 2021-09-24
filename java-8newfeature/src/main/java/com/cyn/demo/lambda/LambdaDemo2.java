package com.cyn.demo.lambda;

import cn.hutool.json.JSONString;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Arrays;
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
}
