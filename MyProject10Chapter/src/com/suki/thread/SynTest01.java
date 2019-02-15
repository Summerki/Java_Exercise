package com.suki.thread;

/**
 * 线程安全：在并发时保证数据的正确性、效率尽可能高
 * synchronized
 * 1、同步方法
 * 2、同步块
 */

public class SynTest01 {
    public static void main(String[] args) {
        // 一份资源
        SafeWeb12306 web = new SafeWeb12306();
        // 多个代理
        new Thread(web, "码畜").start();
        new Thread(web, "码农").start();
        new Thread(web, "蚂蟥").start();
    }


}

class SafeWeb12306 implements Runnable{
    // 票数
    private int ticketNums = 10;
    private boolean flag = true;

    @Override
    public void run() {
        while(flag){
            test();
        }
    }

    // 线程安全/同步
    // 这里锁的是这个test函数，但是是对象调用它才会被锁，所以是锁了this对象
    public synchronized void test(){
        if(ticketNums <= 0){
            flag = false;
            return;
        }
        // 模拟延时
        try{
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
    }
}
