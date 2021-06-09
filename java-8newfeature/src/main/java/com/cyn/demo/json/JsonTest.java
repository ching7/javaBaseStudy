package com.cyn.demo.json;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-06-09
 */
public class JsonTest {

    @Test
    public void testJsonToStr(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg_type","Silent");
        jsonObject.put("agent_id",1);
        jsonObject.put("agent_no",1);
        String message = jsonObject.toString();
        System.out.println(message);
    }
}
