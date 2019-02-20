package com.suki.thread;

import com.sun.org.apache.xalan.internal.xsltc.runtime.AbstractTranslet;

/**
 * @author Summerki
 */
public class StartRun implements Runnable {
    public static void main(String[] args) {
//        // 创建实现类对象
//        StartRun sr = new StartRun();
//        // 创建代理类对象
//        Thread t = new Thread(sr);
//        // 启动
//        t.start();

        // 将上面合成一句代码
        // java里面如果一个对象只使用了一次，可以使用匿名操作
        new Thread(new StartRun()).start();

        for(int i = 0; i < 20; i++){
            System.out.println("一边coding");
        }
    }

    @Override
    public void run() {
        for(int i = 0; i < 20; i++){
            System.out.println("一边听歌");
        }
    }
}
