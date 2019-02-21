package com.suki.jvm;

public class Demo01 {
    static {
        System.out.println("静态初始化Demo01");
    }
    public static void main(String[] args) {
        System.out.println("Demo01的main方法");
        A a = new A();
        System.out.println(a.width);
        A a2 = new A(); // 这里可以说明类初始化在程序中只会发生一次
    }
}

class A extends A_Father{
    public static int width = 100;

    static {
        System.out.println("静态初始化A");
    }

    public A(){
        System.out.println("创建A类对象");
    }
}

class A_Father{
    static {
        System.out.println("静态初始化A_Father");
    }
}
