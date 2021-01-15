package com.cyn.demo.bean;

/**
 * @author chenyanan
 * Created by chenyanan on 2021/1/15
 */
public class JdkStaticProxyMishu implements Gongneng {

    // 静态代理直接指定要代理的类
    private Gongneng laozong = new Laozong();

    @Override
    public void chifan() {
        System.out.println("chifan before ===");
        laozong.chifan();
        System.out.println("chifan after ===");
    }

    @Override
    public String xiaomubiao() {
        System.out.println("xiaomubiao before ===");
        laozong.xiaomubiao();
        System.out.println("xiaomubiao after ===");
        return "JdkStaticProxyMishu-xiaomubiao";
    }

    @Override
    public String jianghua(String msg) {
        System.out.println("jianghua before ===" + msg);
        laozong.jianghua(msg);
        System.out.println("jianghua after ===" + msg);
        return "JdkStaticProxyMishu-jianghua" + msg;
    }
}
