package com.suki.thread;

/**
 * @author Summerki
 */
public class BlockedSleep03 {
    public static void main(String[] args) throws InterruptedException {
        // 倒数10个数  1秒1个
        int num = 10;
        while (true){
            Thread.sleep(1000);
            System.out.println(num--);
        }
    }
}
