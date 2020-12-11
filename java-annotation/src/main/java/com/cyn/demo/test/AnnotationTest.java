package com.cyn.demo.test;

import com.cyn.demo.myAnnotation.JianCha;

/**
 * 文件描述
 *
 * @ProjectName: java-annotation
 * @Package: com.cyn.test
 * @Date 2020/7/1 17:06
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class AnnotationTest {
    @JianCha
    public void suanShu(){
        System.out.println("1234567890");
    }
    @JianCha
    public void jiafa(){
        System.out.println("1+1="+1+1);
    }
    @JianCha
    public void jiefa(){
        System.out.println("1-1="+(1-1));
    }
    @JianCha
    public void chengfa(){
        System.out.println("3 x 5="+ 3*5);
    }
    @JianCha
    public void chufa(){
        System.out.println("6 / 0="+ 6 / 0);
    }

    public void ziwojieshao(){
        System.out.println("我写的程序没有 bug!");
    }
}
