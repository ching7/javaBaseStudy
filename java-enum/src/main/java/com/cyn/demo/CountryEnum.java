package com.cyn.demo;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/23
 */
public enum CountryEnum {
    ONE(1, "齐"), TWO(2, "楚"), THREE(3, "燕"), FOUR(4, "赵"), FIVE(5, "魏"), SIX(6, "韩");
    private Integer code;
    private String message;

    CountryEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static CountryEnum forEachCountryEnum(int code) {
        CountryEnum[] arrays = CountryEnum.values();
        for (CountryEnum e :
                arrays) {
            if (e.code == code) {
                return e;
            }
        }
        return null;
    }
}
/**
 * mysql dbname = CountryEnum
 * table
 * one
 * ID username age birth useremail
 * 1  齐       200 200   200@email.com
 */