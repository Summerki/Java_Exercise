package com.suki.thread;

import sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl;

/**
 * @author Summerki
 */
public class StartThread extends Thread {
    /**
     * 重写run方法，因为run是线程的入口点
     */
    @Override
    public void run() {
        // 线程体
        for(int i = 0; i < 20; i++){
            System.out.println("一边听歌");
        }
    }

    public static void main(String[] args) {
        // 启动线程的步骤
        // 1 创建子类对象
        StartThread st = new StartThread();
        // 2 调用子类对象的start方法
        st.start();
        //st.run();// 这只是普通方法的调用，所以这样还是只有一个线程
        for(int i = 0; i < 20; i++){
            System.out.println("一边coding");
        }
    }
}
