package com.cyn.demo.stringDemo;

import cn.hutool.crypto.digest.MD5;
import org.junit.Test;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-09-13
 */
public class StringDemo {

    @Test
    public void testStringReplace() {
        String t = "aicc:acd:seat:seat_queue_10086_normal";
        String s = t.replaceFirst("aicc:acd:seat:", "aicc:acd:seat:bak_");
        MD5 md5 = new MD5();
        String s1 = md5.digestHex(t);
        System.out.println(s);
    }
}
