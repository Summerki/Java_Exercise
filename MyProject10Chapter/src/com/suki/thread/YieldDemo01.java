package com.suki.thread;

/**
 * @author Summerki
 */
public class YieldDemo01 {
    public static void main(String[] args) {
        MyYield my = new MyYield();
        new Thread(my, "线程1").start();
        new Thread(my, "线程2").start();
    }
}

class MyYield implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--->start");
        // 这里进行礼让操作
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "--->end");
    }
}
