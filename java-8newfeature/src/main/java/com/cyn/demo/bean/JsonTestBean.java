package com.cyn.demo.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-06-17
 */
public class JsonTestBean {
    /**
     * 客户姓名
     */
    @JSONField(name = "c")
    private String customerName;
    /**
     * 电话号码
     */
    @JSONField(name = "p")
    private String telphone;
    /**
     * 性别
     */
    @JSONField(name = "s")
    private Integer sex;


    private BeanEnum beanEnum;

    public BeanEnum getBeanEnum() {
        return beanEnum;
    }

    public void setBeanEnum(BeanEnum beanEnum) {
        this.beanEnum = beanEnum;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
