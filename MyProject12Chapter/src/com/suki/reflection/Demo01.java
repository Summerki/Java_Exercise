package com.suki.reflection;

import javax.swing.*;

/**
 * 测试java.lang.Class对象的获取方式
 */
public class Demo01 {
    public static void main(String[] args) {
        String path = "com.suki.bean.User";

        try {
            // 反射机制的核心就是下面这个类的对象
            Class clazz = Class.forName(path);
            System.out.println(clazz); // 输出 class com.suki.bean.User
            // 对象是表示或封装一些数据的；一个类被加载后，JVM会创建一个对应该类的Class对象，类的整个结构信息会放到对应的Class对象中
            // 这个Class对象就像一面镜子一样，通过这面镜子我可以看见对应类的全部信息

            Class clazz2 = Class.forName(path); // 一个类只对应一个Class对象
            System.out.println(clazz2.hashCode()); // 这里的哈希值会和clazz的一样

            Class strClass = String.class;
            Class strClass2 = path.getClass();
            System.out.println(strClass == strClass2); // 返回 true

            Class intClazz = int.class;

            int[] arr01 = new int[10];
            int[][] arr02 = new int[30][3];
            int[] arr03 = new int[30];
            double[] arr04 = new double[10];
            System.out.println(arr01.getClass().hashCode());
            System.out.println(arr02.getClass().hashCode());
            System.out.println(arr03.getClass().hashCode());
            System.out.println(arr04.getClass().hashCode());
            // 可以发现arr01和arr03指向的是同一个对象，因为数组类反射的对象只关心数组里的数据类型和数组的维度，不关心大小
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
