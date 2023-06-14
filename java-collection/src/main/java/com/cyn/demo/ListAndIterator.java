package com.cyn.demo;

import org.junit.Test;

import java.text.Collator;
import java.util.*;

/**
 * @author chenyanan
 * @date 2021/1/29
 * Created by chenyanan on 2021/1/29
 * List和iterator区别
 * 1.list可以add元素，iterator不能新增
 * 2.list没有判断空的方法，iterator有判断空的方法
 * 3.list可以修改，iterator只用于迭代循环，不能修改
 *
 */
public class ListAndIterator {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);

        Map<String, Integer> mapDemo = new HashMap<String, Integer>();
        mapDemo.put("a", 1);
        mapDemo.put("b", 2);
        Iterator<String> iterator = mapDemo.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println("===" + mapDemo.get(iterator.next()));
        }
    }
    @Test
    public void test(){
        List<String> stringList = Arrays.asList("a李四", "b阿毛", "老王", "小李", "小董");
        stringList.sort((x,y)->{
            Collator instance = Collator.getInstance(Locale.CHINA);
            return instance.compare(x, y);
        } );
        System.out.println("------------------------------------");
        stringList.forEach(System.out::println);

    }
}