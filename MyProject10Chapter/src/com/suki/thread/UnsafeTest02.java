package com.suki.thread;

/**
 * @author Summerki
 */
public class UnsafeTest02 {
    public static void main(String[] args) {
        // 账户
        Account account = new Account(100, "结婚礼金");
        Drawing you = new Drawing(account, 80, "可悲的我");
        Drawing wife = new Drawing(account, 90, "happy的她");
        you.start();
        wife.start();
    }
}

// 账户
class Account{
    int money; // 金额
    String name; // 名称

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

// 模拟提款
class Drawing extends Thread{

    Account account; // 取钱的账户
    int drawingMoney; // 取的钱数
    int packetTotal; // 口袋的总数

    @Override
    public void run() {
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

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }
}
