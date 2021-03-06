package com.suki.thread;

/**
 * @author Summerki
 */
public class BlockedSleep01 implements Runnable {
    // 票数
    private int ticketNums = 99;

    @Override
    public void run() {
        while(true){
            if(ticketNums < 0){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--->" + ticketNums--);//Thread.currentThread().getName()就是下面的1号、2号、3号
        }
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()); // 输出main
        // 一份资源
        Web12306 web = new Web12306();
        // 多个代理
        new Thread(web,"1号").start();
        new Thread(web,"2号").start();
        new Thread(web,"3号").start();
    }
}
