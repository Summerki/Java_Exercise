package com.suki.reflection;

import com.suki.bean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 通过反射API动态的操作:构造器、方法、属性
 */
public class Demo03 {
    public static void main(String[] args) {
        String path = "com.suki.bean.User";
        try {
            Class clazz = Class.forName(path);

            // 通过反射API调用构造方法，构造对象
            User u = (User) clazz.newInstance(); //其实是调用了User的无参构造器
            System.out.println(u);
            // 调用User的有参构造器
            Constructor<User> c = clazz.getDeclaredConstructor(int.class, int.class, String.class);
            User u2 = c.newInstance(1001, 18, "高琪");
            System.out.println(u2.getUname());

            // 通过反射API调用普通方法
            User u3 = (User) clazz.newInstance();
            Method method = clazz.getDeclaredMethod("setUname", String.class);
            method.invoke(u3, "小虎");  // 这两行相当于 u3.setUname("小虎")
            System.out.println(u3.getUname());

            // 通过反射API操作属性
            User u4 = (User) clazz.newInstance();
            Field f = clazz.getDeclaredField("uname");
            f.setAccessible(true); // 表示这个属性不需要做安全检查了，可以直接访问;方法也有这个(在用到私有方法、私有属性时很有用)
            f.set(u4, "小何"); // 通过反射直接写属性
            System.out.println(u4.getUname());  // 通过反射直接读属性的值
            System.out.println(f.get(u4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

