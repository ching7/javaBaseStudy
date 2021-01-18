package com.cyn.demo.bean;

/**
 * @author chenyn
 * @version 1.0
 * @date 2019/8/29 23:34
 */
public class MainDemo {
    public static void main(String[] args) {
/*        // 1 jdk静态代理
        JdkStaticProxyMishu staticProxyMishu = new JdkStaticProxyMishu();
        // 空入参空返回
        staticProxyMishu.chifan();
        // 空入参有返回
        String xiaomubiao = staticProxyMishu.xiaomubiao();
        System.out.println(xiaomubiao);
        // 有入参有返回
        String jianghua = staticProxyMishu.jianghua("讲话内容");
        System.out.println(jianghua);*/

        // 2 jdk动态代理
        // 保存生成的代理类的字节码文件
        // 启动设置 -Dsun.misc.ProxyGenerator.saveGeneratedFiles=true
        Gongneng proxyLongzong = new JdkDynamicProxyMishu(new Laozong()).getProxy();
        proxyLongzong.chifan();
        String xiaomubiao = proxyLongzong.xiaomubiao();
        System.out.println(xiaomubiao);
        String jianghua1 = proxyLongzong.jianghua("讲话内容");
        System.out.println(jianghua1);

        Gongneng proxyLongzong2 = new JdkDynamicProxyMishu(new Laozong2()).getProxy();
        proxyLongzong2.chifan();
        String xiaomubiao1 = proxyLongzong2.xiaomubiao();
        System.out.println(xiaomubiao1);
        String jianghua2 = proxyLongzong2.jianghua("讲话内容");
        System.out.println(jianghua2);

    }
}