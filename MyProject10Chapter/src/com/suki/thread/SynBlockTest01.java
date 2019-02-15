package com.suki.thread;

/**
 * 线程安全：在并发时保证数据的正确性、效率尽可能高
 * synchronized
 * 1、同步方法
 * 2、同步块:目标更明确
 */

public class SynBlockTest01 {
    public static void main(String[] args) {
        // 账户
        Account account = new Account(100, "结婚礼金");
        SynDrawing you = new SynDrawing(account, 80, "可悲的我");
        SynDrawing wife = new SynDrawing(account, 90, "happy的她");
        you.start();
        wife.start();
    }
}

// 模拟提款  线程安全
class SynDrawing extends Thread{

    Account account; // 取钱的账户
    int drawingMoney; // 取的钱数
    int packetTotal; // 口袋的总数

    @Override
    public void run() {
        test();
    }

    // 目标锁定account
    public void test(){

        // 增加一段非常重要的提高性能的代码
        // 当钱小于等于0时就不用进入同步块了，节约了大量的时间
        // 提高并发量
        if(account.money <= 0){
            return;
        }

        // 同步块
        synchronized (account){
            if(account.money - drawingMoney < 0){
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money -= drawingMoney;
            packetTotal += drawingMoney;
            System.out.println(this.getName() + "---->账户余额为：" + account.money);
            System.out.println(this.getName() + "---->口袋的钱为：" + packetTotal);
        }
    }

    public SynDrawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }
}
