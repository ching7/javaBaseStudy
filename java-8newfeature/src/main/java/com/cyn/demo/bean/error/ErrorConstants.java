package com.cyn.demo.bean.error;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2022-03-07
 */
public class ErrorConstants {
    /**
     * 呼叫失败
     **/
    public static int ERR_AICC_PHONE_CALL_FAIL = 30000;
    /**
     * 号码不存在
     **/
    public static int ERR_AICC_PHONE_NOTEXIST = 30001;
    static {
        ErrorConsts.errorNoMap.put(30000, "工作流发起失败");
        ErrorConsts.errorNoMap.put(30001, "受理单信息不存在");
    }
}
