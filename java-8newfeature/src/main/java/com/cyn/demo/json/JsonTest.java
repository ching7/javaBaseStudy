package com.cyn.demo.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cyn.demo.bean.BeanEnum;
import com.cyn.demo.bean.CallTemplateQuestion;
import com.cyn.demo.bean.JsonTestBean;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-06-09
 */
public class JsonTest {

    @Test
    public void getJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("1", "1sss");
        jsonObject.put("2", "1sss");
        for (String key : jsonObject.keySet()) {
            // 获得key
            // 根据key获得value, value也可以是JSONObject,JSONArray,使用对应的参数接收即可
            String value = jsonObject.getString(key);
            System.out.println("key: " + key + ",value" + value);
        }
    }

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

    @Test
    public void testJsonObject() {
        String templateQuestionJson = "[{\"questionValue\":\"满意度\",\"questionKey\":\"myd\",\"answerType\":\"1\",\"answerJson\":[{\"answerKey\":\"my\",\"answerValue\":\"满意\"},{\"answerKey\":\"jbmy\",\"answerValue\":\"基本满意\"},{\"answerKey\":\"bmy\",\"answerValue\":\"不满意\"}]},{\"questionValue\":\"降水量\",\"questionKey\":\"jsl\",\"answerType\":\"2\",\"answerJson\":\"\"}]";
        CallTemplateQuestion callTemplateQuestion = new CallTemplateQuestion();
        List<CallTemplateQuestion> callTemplateQuestions = JSONObject.parseArray(templateQuestionJson, CallTemplateQuestion.class);
    }


    @Test
    public void testJsonConvert() {
        // String js = "{\"requestType\":\"register\",\"userName\":\"1011\",\"data\":{\"expireTime\":10}}";
        String js = "{\"eventType\":\"register\",\"userName\":\"1016\",\"data\":{\"registered\":true}}";

        JSONObject msgObject = JSONObject.parseObject(js);
        JSONObject data = (JSONObject) msgObject.get("data");
        Object registered = data.get("registered");
    }

    @Test
    public void testJsonConvert2() {
        String jsonObject = "{\"agent_no\":\"1015\",\"caller_number\":\"1017\",\"msg_type\":\"AgentStatus\",\"status\":0,\"reason\":\"NO_ANSWER\",\"timestamp\":\"2021-12-22 14:21:45\",\"uuid\":\"5044e2d0-62ee-11ec-8d37-6d7f5b23cf07\"}";
        JSONObject msgObject = JSONObject.parseObject(jsonObject);
        String reason = msgObject.getString("reason");
        System.out.println("NO_ANSWER".equals(reason));
    }

    @Test
    public void testJsonConvert3() {
        String jsonObject = "[{\"text\":\"playover\",\"questionStd\":\"\",\"slots\":{},\"interIdx\":9,\"confidence\":\"\",\"promptText\":null,\"promptWav\":null},{\"text\":\"没有。\",\"questionStd\":\"没意见\",\"slots\":{},\"interIdx\":9,\"confidence\":\"credible\",\"promptText\":\"好的,感谢您对我们工作的支持，祝您生活愉快，再见。\",\"promptWav\":\"满意度没有意见\"},{\"text\":\"playover\",\"questionStd\":\"\",\"slots\":{},\"interIdx\":8,\"confidence\":\"\",\"promptText\":\"[p0]\",\"promptWav\":\"空节点\"},{\"text\":\"非常满意。\",\"questionStd\":\"非常满意\",\"slots\":{},\"interIdx\":7,\"confidence\":\"credible\",\"promptText\":\"感谢您对我们服务的认可，请问您对市民卡今后的服务还有什么意见和建议吗？\",\"promptWav\":\"满意度非常满意\"},{\"text\":\"1\",\"questionStd\":\"理财肯定\",\"slots\":{},\"interIdx\":6,\"confidence\":\"acceptable\",\"promptText\":\"打扰您1分钟时间，我们想对您2021年12月23日在萧山大厅办理的成人市民卡补换业务做个简单的满意度调研，请您对工作人员的服务做一下评价，您可以选择说“非常满意、满意、一般、不满意或者非常不满意”。\",\"promptWav\":\"满意度超时1\"},{\"text\":\"playover\",\"questionStd\":\"\",\"slots\":{},\"interIdx\":5,\"confidence\":\"\",\"promptText\":\"[p0]\",\"promptWav\":\"空节点\"},{\"text\":\"嗯是的。\",\"questionStd\":\"理财肯定\",\"slots\":{},\"interIdx\":4,\"confidence\":\"credible\",\"promptText\":\"打扰您1分钟时间，我们想对您2021年12月23日在萧山大厅办理的成人市民卡补换业务做个简单的满意度调研，请您对工作人员的服务做一下评价，您可以选择说“非常满意、满意、一般、不满意或者非常不满意”。\",\"promptWav\":\"萧山满意度回访\"},{\"text\":\"playover\",\"questionStd\":\"\",\"slots\":{},\"interIdx\":3,\"confidence\":\"\",\"promptText\":\"[p0]\",\"promptWav\":\"空节点\"},{\"text\":\"playover\",\"questionStd\":\"\",\"slots\":{},\"interIdx\":2,\"confidence\":\"\",\"promptText\":\"您好，杭州市民卡客户服务中心给您来电，请问您是李泽鑫先生吗？\",\"promptWav\":\"回访身份确认\"},{\"text\":\"\",\"questionStd\":\"\",\"slots\":{},\"interIdx\":1,\"confidence\":\"\",\"promptText\":\"[p10]\",\"promptWav\":\"空节点1\"}]";
    }
}
