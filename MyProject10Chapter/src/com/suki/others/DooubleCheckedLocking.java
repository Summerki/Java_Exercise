package com.suki.others;

/**
 * 单例模式：懒汉式套路基础上加入并发控制；保证在多线程环境下，对外存在一个对象
 * 1、构造器私有化-->避免外部bew构造器
 * 2、提供私有的静态属性-->存储对象地址
 * 3、提供公共的静态方法-->获取属性
 */
public class DooubleCheckedLocking {
    // 2、提供私有的静态属性
    private static volatile DooubleCheckedLocking instance;
    // 上面没有volatile其他线程可能会访问到一个没有初始化的对象

    // 1、构造器私有化
    private DooubleCheckedLocking(){

    }

    // 3、提供公共的静态方法
    public static DooubleCheckedLocking getInstance(){
        // 再次检测
        if(null != instance){ // 避免不必要的同步，已经存在对象
            return instance;
        }
        synchronized (DooubleCheckedLocking.class){
            if(null == instance){
                instance = new DooubleCheckedLocking();
                // 上面new会做的3件事情：1、开辟空间2、初始化对象信息3、返回对象的地址引用
                // 这一步有可能会出现指令重排，所以加了volatile
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println(DooubleCheckedLocking.getInstance());
        });
        t.start();
        System.out.println(DooubleCheckedLocking.getInstance());
    }
}
