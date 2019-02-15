package com.suki.thread;

public class SynBlockTest03 {
    public static void main(String[] args) {
        // 一份资源
        SynWeb12306 web = new SynWeb12306();
        // SynWeb12306
        new Thread(web, "码畜").start();
        new Thread(web, "码农").start();
        new Thread(web, "蚂蟥").start();
    }
}

class SynWeb12306 implements Runnable{
    // 票数
    private int ticketNums = 10;
    private boolean flag = true;

    @Override
    public void run() {
        while(flag){
            test5();
        }
    }

    // 线程安全/同步
    // 这里锁的是这个test函数，但是是对象调用它才会被锁，所以是锁了this对象
    public synchronized void test1(){
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

    // 将上面代码修改为同步块代码
    // 线程安全 范围太大 但是效率低下
    public void test2(){
        synchronized (this){   // 这里使用this是为了同时锁ticketNums和flag
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

    // 再次修改上面的代码，只锁ticketNums
    // 注意测试结果会出问题，线程不安全，锁定失败
    // 锁定失败的原因：ticketNums对象在变导致锁定失败
    public void test3(){
        synchronized ((Integer)ticketNums){  // 单纯写ticketNums会报错，这里需要的是引用类型
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

    // 缩小test2锁定的范围
    // 但是还是会出问题，范围太小锁不住
    public void test4(){
        synchronized (this) {
            if (ticketNums <= 0) {
                flag = false;
                return;
            }
        }
        // 模拟延时
        try{
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
    }

    // 再次修改，尽可能锁定合理的范围（不是指代码 指数据的完整性）
    // 线程安全
    // 双重检测double checking
    public void test5(){
        if(ticketNums <= 0){  // 这里考虑的是没有票的情况
            flag = false;
            return;
        }

        synchronized (this){   // 这里考虑的是最后1张票的情况
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
}

