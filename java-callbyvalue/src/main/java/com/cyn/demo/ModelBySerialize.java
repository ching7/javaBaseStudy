package com.cyn.demo;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/15
 */
public class ModelBySerialize {
    public static void main(String[] args) throws JsonProcessingException {
        /*//定一个Model3类型
        Model3 model3 = new Model3();
        model3.setSuccess(true);

        // is<Properties> 导致的序列化问题
        //使用fastjson(1.2.16)序列化model3成字符串并输出
        System.out.println("Serializable Result With fastjson :" + JSON.toJSONString(model3));

        //使用Gson(2.8.5)序列化model3成字符串并输出
        Gson gson = new Gson();
        System.out.println("Serializable Result With Gson :" + gson.toJson(model3));

        //使用jackson(2.9.7)序列化model3成字符串并输出
        ObjectMapper om = new ObjectMapper();
        System.out.println("Serializable Result With jackson :" + om.writeValueAsString(model3));*/


        // 错误的序列化
        Model5 model5 = new Model5();
        model5.setSuccess(true);
        Gson gson = new Gson();
        System.out.println(gson.fromJson(JSON.toJSONString(model5), Model5.class));
    }
}

class Model1 {
    private Boolean isSuccess;

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }
}

class Model2 {
    private Boolean success;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}

class Model3 implements Serializable {
    private static final long serialVersionUID = 1836697963736227954L;
    private boolean isSuccess;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

}

class Model4 {
    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}

class Model5 implements Serializable {
    private static final long serialVersionUID = 1836697963736227954L;
    private boolean isSuccess;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Model3.class.getSimpleName() + "[", "]")
                .add("isSuccess=" + isSuccess)
                .toString();
    }
}