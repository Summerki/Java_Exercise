package com.suki.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.METHOD, ElementType.TYPE})  // 这代表一个元注解，表示只能使用在方法上
@Retention(RetentionPolicy.RUNTIME)
public @interface SxtAnnotation01 {

    // 一定注意这里不是方法，是配置参数
    String studentName() default "";  // 这里清楚地说明了每一个方法实际上是声明了一个配置参数
    int age() default 0;
    int id() default -1;

    String[] schools() default {"清华大学", "中南大学"};

}
