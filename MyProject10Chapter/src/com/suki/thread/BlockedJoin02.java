package com.suki.thread;

/**
 * @author Summerki
 */
public class BlockedJoin02 {
    public static void main(String[] args) {
        System.out.println("爸爸和儿子去买烟的故事");
        new Thread(new Father()).start();
    }
}

class Father implements Runnable{
    @Override
    public void run() {
        System.out.println("想抽烟，发现没了");
        System.out.println("让儿子去买烟");
        Thread t = new Thread(new Son());
        t.start();
        try {
            t.join(); // 因为join写在Father内，所以Father被阻塞
            System.out.println("老爸接过烟,故事完毕！");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("儿子走丢了");
        }

    }
}

class Son implements Runnable{
    @Override
    public void run() {
        System.out.println("接过老爸的钱出去了");
        System.out.println("路边有个游戏厅，进去玩了10s");
        for(int i = 0; i < 10; i++){
            System.out.println(i + "s过去了...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("赶紧买烟去");
        System.out.println("拿着烟回家了");
    }
}
