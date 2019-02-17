package com.suki.thread;

/**
 * @author Summerki
 */
public class DaemonTest {
    public static void main(String[] args) {
        God god = new God();
        Human human = new Human();
        Thread t = new Thread(god);
        t.setDaemon(true);// 将用户线程调整为守护线程
        t.start();
        new Thread(human).start();
    }
}

class Human implements Runnable{
    @Override
    public void run() {
        for(int i = 1; i < 365 * 100; i++){
            System.out.println("happy life");
        }
        System.out.println("ooooo...");
    }
}

class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("god bless you...");
        }
    }
}

