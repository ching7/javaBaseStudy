package com.cyn.demo.map;

import com.cyn.demo.bean.People;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-07-21
 */
public class ListToMap {
    public static void main(String[] args) throws Exception {
        List<People> peoples = new ArrayList<>();
        peoples.add(new People("wanger",1));
        peoples.add(new People("lisi",2));
        List<Map<Object, Object>> maps = EntityConvertMap(peoples);

        Map<Object, Object> objectMap = EntityConvertMap(new People("wanger", 1));
    }
    /**
     * list to map
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List<Map<Object,Object>> EntityConvertMap(List<T> list) {
        List<Map<Object, Object>> l = new LinkedList<>();
        try {
            for (T t : list) {
                Map<Object, Object> map = new HashMap<>();
                Method[] methods = t.getClass().getMethods();
                for (Method method : methods) {
                    if (method.getName().startsWith("get")) {
                        String name = method.getName().substring(3);
                        name = name.substring(0, 1).toLowerCase() + name.substring(1);
                        Object value = method.invoke(t);
                        map.put(name, value);
                    }
                }
                l.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }

    /**
     * Object to map
     *
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> Map<Object, Object> EntityConvertMap(Object obj) throws Exception {
        Map<Object, Object> objectMap = new HashMap<>();
        try {
            Method[] methods = obj.getClass().getMethods();
            for (Method method : methods) {
                if (method.getName().startsWith("get")) {
                    String name = method.getName().substring(3);
                    name = name.substring(0, 1).toLowerCase() + name.substring(1);
                    Object value = method.invoke(obj);
                    objectMap.put(name, value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return objectMap;
    }
}
