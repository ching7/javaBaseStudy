package com.cyn.demo.stream;

import com.cyn.demo.bean.People;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 文件描述
 *
 * @ProjectName: java-8newfeature
 * @Package: com.cyn.stream
 * @Date 2020/4/15 11:09
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class StreamDemo {
    public static void main(String[] args) {
        // 1.stream 生成流
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<People> peopleList = new ArrayList<>();
        peopleList.add(new People("A", 1));
        peopleList.add(new People("B", 2));

        /*List<String> filtered = strings.stream()
                .filter(string -> !string.isEmpty())
                .collect(Collectors.toList());
        System.out.println(strings);
        System.out.println(filtered);
        System.out.println("===============");

        // 2.forEach 应用于stream新的方法 'forEach' 来迭代流中的每个数据
        // filtered.forEach(string -> System.out.println(string));
        strings.stream()
                .forEach(string -> System.out.println(string));*/
        System.out.println("===============");

        // 3.map 用于映射每个元素到对应的结果（对流中的每个元素做操作后返回流）

        // peek\map 都可以用来修改数据
        // peek没有返回值的，它只是对Stream中的元素进行某些操作，但是操作之后的数据并不返回到Stream中，所以Stream中的元素还是原来的元素。
        // map是有返回值的，这意味着对于Stream的元素的所有操作都会作为新的结果返回到Stream中。
        // 这就是为什么peek String不会发生变化而peek Object会发送变化的原因。
        strings.stream()
                .map(string -> string + "Map")
                .peek(s -> {
                    System.out.println(s.toUpperCase());
                })
                .forEach(string -> System.out.println(string));
        System.out.println("===============");
        peopleList.stream()
                .map(people -> new People(people.getName(), 2))
                .peek(people -> {
                    people.setName("ABC");
                })
                .forEach(people -> System.out.println(people));

        // 4.filter 用于通过设置的条件过滤出元素
        /*strings.stream()
                .filter(s -> s.contains("b"))
                .forEach(s -> System.out.println(s));
        System.out.println("===============");

        // 5.limit 于获取指定数量的流
        strings.stream()
                .limit(2)
                .forEach(s -> System.out.println(s));
        System.out.println("===============");

        // 6.并行（parallel）程序
        // 采用并行流收集元素到集合中时，最好调用collect方法，采用Foreach方法或者map方法可能会出现线程安全问题
        strings.parallelStream()
                .filter(s -> s.contains("c"))
                .forEach(s -> System.out.println(s));
        System.out.println("===============");

        // 7.Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。Collectors 可用于返回列表或字符串：
        String filtereds = strings.stream()
                .filter(string -> !string.isEmpty())
                .collect(Collectors.joining("."));
        List<String> filteredss = strings
                .stream()
                .filter(string -> !string.isEmpty())
                .collect(Collectors.toList());
        System.out.println(filtereds);
        System.out.println(filteredss);
        System.out.println("===============");

        //8. 收集器也非常有用。它们主要用于int、double、long等基本类型上，它们可以用来产生类似如下的统计结果。
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics statistics = numbers.stream()
                .mapToInt(x -> x)
                .summaryStatistics();
        System.out.println(statistics.getAverage());*/
    }
}
