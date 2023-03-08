package com.cyn.demo.bean.error;

/**
 * The interface Base exception.
 * @author ynchen9
 */
public interface BaseException {
    /**
     * 错误码
     *
     * @return the result code
     */
    String getResultCode();

    /**
     * 错误信息
     *
     * @return the result msg
     */
    String getResultMsg();
}
