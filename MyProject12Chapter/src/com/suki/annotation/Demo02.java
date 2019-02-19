package com.suki.annotation;

/**
 * 在这个测试类中使用自定义注解
 */

@SxtAnnotation01 // 自定义注解，因为其后面没有加参数，所以是使用自定义注解里面的默认值
public class Demo02 {

    @SxtAnnotation01(age = 19, studentName = "老高", id = 1001,
                        schools = {"北京大学"}) // 使用自定义注解而且括号里还重新自定义了注解里面的内容
    public void test(){

    }

    @SxtAnnotation02("aaaa") // 在使用只有一个参数的注解时可以将参数名省略（属性名加也行不加也行）
    public void test2(){

    }
}
