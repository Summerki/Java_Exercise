package com.suki.thread;

/**
 * @author Summerki
 */
public class YieldDemo02 {
    public static void main(String[] args) {
        new Thread(()->{
            for(int i = 0; i < 100; i++){
                System.out.println("lambda...");
            }
        }).start();

        for(int i = 0; i < 100; i++){
            if(i % 20 == 0){
                Thread.yield();// 因为这是在main线程中，所以这代表main线程会礼让
            }
            System.out.println("main...");
        }
    }
}
