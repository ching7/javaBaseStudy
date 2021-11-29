package com.cyn.demo.generic;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: T: Type（Java 类）通用泛型类型，通常作为第一个泛型类型
 * S: 通用泛型类型，如果需要使用多个泛型类型，可以将S作为第二个泛型类型
 * U: 通用泛型类型，如果需要使用多个泛型类型，可以将U作为第三个泛型类型
 * V: 通用泛型类型，如果需要使用多个泛型类型，可以将V作为第四个泛型类型
 * E: 集合元素泛型类型，主要用于定义集合泛型类型
 * K: 映射-键泛型类型，主要用于定义映射泛型类型
 * V: 映射-值泛型类型，主要用于定义映射泛型类型
 * N: Number数值泛型类型，主要用于定义数值类型的泛型类型
 * ?: 表示不确定的java类型
 * @Author: ynchen9
 * @CreateTime: 2021-11-29
 */
public class ResultTemp<T> extends BaseResult<T> implements Serializable {
    private static final long serialVersionUID = -7268040542410707954L;

    public ResultTemp() {

    }

    public ResultTemp(boolean success) {
        this.setSuccess(success);
    }

    public ResultTemp(boolean success, String message) {
        this.setSuccess(success);
        this.setMessage(message);
    }

    public ResultTemp(boolean success, String message, T data) {
        this.setSuccess(success);
        this.setMessage(message);
        this.setData(data);
    }

    public static ResultTemp ok() {
        return ok(BaseErrorCode.Common.SUCCESS);
    }

    public static <T> ResultTemp<T> ok(IMessage msg) {
        return baseCreate(msg.getCode(), msg.getMessage(), true);
    }

    public static ResultTemp fail() {
        return fail(BaseErrorCode.Common.UNKNOWN_ERROR);
    }

    public static ResultTemp fail(IMessage message) {
        return fail(message.getCode(), message.getMessage());
    }


    public static ResultTemp fail(String code, String msg) {
        return baseCreate(code, msg, false);
    }

    private static <T> ResultTemp<T> baseCreate(String code, String msg, boolean success) {
        ResultTemp<T> result = new ResultTemp<T>();
        result.setCode(code);
        result.setSuccess(success);
        result.setMessage(msg);
        result.setTimestamp(new Date().toString());
        return result;
    }

    public ResultTemp<T> setResult(T data) {
        this.setData(data);
        return this;
    }

    @Override
    public T getData() {
        return (T) super.getData();
    }
}
