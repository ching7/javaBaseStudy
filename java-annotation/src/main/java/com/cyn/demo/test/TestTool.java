package com.cyn.demo.test;
import com.cyn.demo.myAnnotation.JianCha;

import java.lang.reflect.Method;
/**
 * 文件描述
 *
 * @ProjectName: java-annotation
 * @Package: com.cyn.test
 * @Date 2020/7/1 17:13
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class TestTool {
    public static void main(String[] args) {
        // spring框架中，从容器中获取
        // 注解使用的类
        AnnotationTest testObj = new AnnotationTest();
        Class clazz = testObj.getClass();
        Method[] method = clazz.getDeclaredMethods();
        //用来记录测试产生的 log 信息
        StringBuilder log = new StringBuilder();
        // 记录异常的次数
        int errornum = 0;
        for ( Method m: method ) {
            // 只有被 @Jiecha 标注过的方法才进行测试
            if ( m.isAnnotationPresent( JianCha.class )) {
                try {
                    // setAccessible是启用和禁用访问安全检查的开关
                    // 值为 true 则指示反射的对象在使用时应该取消 Java 语言访问检查。值为 false 则指示反射的对象应该实施 Java 语言访问检查。
                    m.setAccessible(true);
                    // 执行该方法
                    m.invoke(testObj, null);
                } catch (Exception e) {
                    //e.printStackTrace();
                    errornum++;
                    log.append(m.getName());
                    log.append(" ");
                    log.append("has error:");
                    log.append("\n\r  caused by ");
                    //记录测试过程中，发生的异常的名称
                    log.append(e.getCause().getClass().getSimpleName());
                    log.append("\n\r");
                    //记录测试过程中，发生的异常的具体信息
                    log.append(e.getCause().getMessage());
                    log.append("\n\r");
                }
            }
        }
        log.append(clazz.getSimpleName());
        log.append(" has  ");
        log.append(errornum);
        log.append(" error.");
        // 生成测试报告
        System.out.println(log.toString());
    }
}
