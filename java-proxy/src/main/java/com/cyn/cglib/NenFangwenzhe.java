package com.cyn.cglib;

import com.cyn.bean.Laozong;
import net.sf.cglib.proxy.Enhancer;

public class NenFangwenzhe {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Laozong.class);
        enhancer.setCallback(new NewMishu());
        Laozong laozong =  (Laozong)enhancer.create();
        laozong.chifan();
    }
}
