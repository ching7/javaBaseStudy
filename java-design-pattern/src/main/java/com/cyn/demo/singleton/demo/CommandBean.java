package com.cyn.demo.singleton.demo;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/16
 * 需要被单例实现的bean
 */
public class CommandBean {
    String beanName = "CommandBean";

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
