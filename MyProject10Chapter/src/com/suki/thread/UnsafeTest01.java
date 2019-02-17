package com.suki.thread;

/**
 * @author Summerki
 */
public class UnsafeTest01 implements Runnable {
    // 票数
    private int ticketNums = 99;

    private boolean flag = true;

    @Override
    public void run() {
        while(flag){
            test();
        }
    }

    public void test(){
        if(ticketNums < 0){
            flag = false;
            return;
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "--->" + ticketNums--);//Thread.currentThread().getName()就是下面的1号、2号、3号

    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()); // 输出main
        // 一份资源
        UnsafeTest01 web = new UnsafeTest01();
        // 多个代理
        new Thread(web,"1号线程").start();
        new Thread(web,"2号线程").start();
        new Thread(web,"3号线程").start();
    }
}
