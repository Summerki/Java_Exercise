package com.suki.thread;

/**
 * @author Summerki
 */
public class Racer implements Runnable{

    private static String winner; // 胜利者

    @Override
    public void run() {
        for(int steps = 1; steps <= 100; steps++){
            System.out.println(Thread.currentThread().getName() + "--->" + steps);
            // 比赛是否结束
            boolean flag = GameOver(steps);
            if(flag == true){
                break;
            }
        }
    }

    private boolean GameOver(int steps){
        if(winner != null){// 存在胜利者
            return true;
        }else{
            if(steps == 100){
                winner = Thread.currentThread().getName();
                System.out.println("winner---->" + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Racer racer = new Racer();
        new Thread(racer,"乌龟").start();
        new Thread(racer,"白兔").start();
    }
}
