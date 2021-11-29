package com.cyn.demo.generic;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-11-29
 */
public class BaseErrorCode {
    /**
     * 状态类型
     */
    public static class Common {
        /**
         * 成功
         */
        public static final IMessage SUCCESS = new IMessage("200", "成功");

        public static final IMessage UNKNOWN_ERROR = new IMessage("500", "成功");;
    }
}
