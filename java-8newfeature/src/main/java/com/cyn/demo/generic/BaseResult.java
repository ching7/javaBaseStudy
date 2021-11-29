package com.cyn.demo.generic;

import java.io.Serializable;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-11-29
 */
public abstract class BaseResult<T> implements Serializable {
    private boolean success = false;

    private String message;

    private T data;

    private String code;

    private String timestamp;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
