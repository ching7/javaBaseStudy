package com.cyn.demo.bean.error;

/**
 * @author ynchen9
 */

public enum ExceptionEnum implements BaseException {
    // HTTP CODE
    SUCCESS("200", "成功!"),

    // 通用异常：COMMON_异常场景
    COMMON_OTHER_EXCEPTION("51000", "未知异常!"),
    COMMON_NULL_POINTER_EXCEPTION("51001", "空指针异常!"),
    COMMON_CLASS_NOT_FOUND_EXCEPTION("51002", "不能加载所需要的类异常!"),
    COMMON_NUMBER_FORMAT_EXCEPTION("51003", "数字转换格式异常!"),
    COMMON_IO_EXCEPTION("51004", "I/O异常!"),
    COMMON_FILE_NOT_FOUND_EXCEPTION("51005", "不能加载文件异常!"),

    // ACD相关异常：ACD_异常场景
    ACD_OTHER_EXCEPTION("52000", "路由服务异常!"),

    // SEAT相关异常：SEAT_异常场景
    SEAT_OTHER_EXCEPTION("53000", "坐席服务异常!");

    private final String resultCode;

    private final String resultMsg;

    ExceptionEnum(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    @Override
    public String getResultCode() {
        return resultCode;
    }

    @Override
    public String getResultMsg() {
        return resultMsg;
    }

}
