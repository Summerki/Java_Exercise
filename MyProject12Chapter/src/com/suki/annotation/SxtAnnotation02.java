package com.suki.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.METHOD, ElementType.TYPE})  // 这代表一个元注解，表示只能使用在方法上
@Retention(RetentionPolicy.RUNTIME)
public @interface SxtAnnotation02 {
    String value(); // 如果一个注解里面只有一个参数，通常将其名字定义为value
    // 还要注意一点，上面的value值我没有填默认值，所以使用这个注解时一定要赋值默认值
}
