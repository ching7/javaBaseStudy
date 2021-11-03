package com.cyn.demo.bean;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-11-03
 */
public class BeanCopyUtils {
    public static void copy(Object source, Object dest) throws Exception {
        // 获取属性
        BeanInfo sourceBean = Introspector.getBeanInfo(source.getClass(), Object.class);
        PropertyDescriptor[] sourceProperty = sourceBean.getPropertyDescriptors();

        BeanInfo destBean = Introspector.getBeanInfo(dest.getClass(), Object.class);
        PropertyDescriptor[] destProperty = destBean.getPropertyDescriptors();

        try {
            for (PropertyDescriptor descriptor : sourceProperty) {
                for (PropertyDescriptor propertyDescriptor : destProperty) {
                    if (descriptor.getName().equals(propertyDescriptor.getName()) && descriptor.getPropertyType() == propertyDescriptor.getPropertyType()) {
                        // 调用source的getter方法和dest的setter方法
                        propertyDescriptor.getWriteMethod().invoke(dest, descriptor.getReadMethod().invoke(source));
                        break;
                    }
                }
            }
        } catch (Exception e) {
            throw new Exception("属性复制失败:" + e.getMessage());
        }
    }
}
