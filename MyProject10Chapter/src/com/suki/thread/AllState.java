package com.suki.thread;



/**
 * @author Summerki
 */
public class AllState {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("......");
        });

        // 观察状态
        Thread.State state = t.getState();
        System.out.println(state); // 输出NEW

        t.start();
        state = t.getState();
        System.out.println(state); // 输出 RUNNABLE
    }
}
