package com.cyn.demo.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cyn.demo.bean.BeanEnum;
import com.cyn.demo.bean.JsonTestBean;
import org.junit.Test;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-06-09
 */
public class JsonTest {

    @Test
    public void beanTestEnum() {
        JsonTestBean jsonTestBean = new JsonTestBean();
        System.out.println(jsonTestBean.getBeanEnum());
    }

    @Test
    public void testJsonToStr() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg_type", "Silent");
        jsonObject.put("agent_id", 1);
        jsonObject.put("agent_no", 1);
        String message = jsonObject.toString();
        System.out.println(message);
    }

    @Test
    public void testJsonFieldAnnotation() {
        // jsonField(name='s')  JSON.toJSONString转换时的字段名称调整
        JsonTestBean testBean = new JsonTestBean();
        testBean.setSex(1);
        testBean.setTelphone("123");
        testBean.setCustomerName("zs");
        // bean to json
        System.out.println(JSON.toJSONString(testBean));

        //JSON 转 Bean
        JsonTestBean entity1 = JSON.parseObject("{'s':1,'c':'张三','p':'1551506609633'}", JsonTestBean.class);
        System.out.println(entity1.getSex());
    }
}
