package com.cyn.demo.bean;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-06-22
 */
public enum BeanEnum {
    WR("1", "wanger"),
    LS("2", "lisi");
    private String code;
    private String name;

    BeanEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
