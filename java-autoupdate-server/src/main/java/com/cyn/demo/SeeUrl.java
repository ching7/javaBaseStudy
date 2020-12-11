package com.cyn.demo;

/**
 * 文件描述
 *
 * @ProjectName: java-autoupdate-server
 * @Package: com.cyn
 * @Date 2020/5/15 16:52
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class SeeUrl {
    /**
     * see地址
     */
    public static String seeUrl = "http://10.20.23.199:8081/";
    /**
     * 认证
     */
    public static String auth = seeUrl + "/acm/system/auth.json";
    /**
     * 上传
     */
    public static String mulUploads = seeUrl + "/acm/dssp/product/mulUploads.json";

    /**
     * see登陆
     */
    public static String loginUrl = seeUrl + "/cas/login";

    /**
     * see客户端操作
     */
    public static String clientUrl = seeUrl + "/acm/";
}
