package com.suki.annotation;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 使用反射读取注解的信息，模拟处理注解信息的流程
 */
public class Demo03 {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("com.suki.annotation.SxtStudent"); // 反射，这个对象就包含了这个类的全部信息

            // 获得类的所有有效注解
            Annotation[] annotations = clazz.getAnnotations();
            for(Annotation annotation : annotations){
                System.out.println(annotation);
            }

            // 获得类的指定注解
            SxtTable st = (SxtTable) clazz.getAnnotation(SxtTable.class);
            System.out.println(st.value());

            // 获得类的属性的注解
            Field f = clazz.getDeclaredField("studentName");
            SxtField sxtField = f.getAnnotation(SxtField.class);
            System.out.println(sxtField.columnName() + "--" +  sxtField.type() + "--" + sxtField.length());

            // 根据获得的表名、字段的信息，拼出DDL语句，然后使用JDBC执行这个SQL，在数据库中生成相关的表
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
