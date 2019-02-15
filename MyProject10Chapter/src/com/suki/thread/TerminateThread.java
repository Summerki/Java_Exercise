package com.suki.thread;

import java.net.SocketTimeoutException;

/**
 * @author Summerki
 */
public class TerminateThread implements Runnable {
    // 第一步：加入标识，标记线程体是否可以运行
    private boolean flag = true;
    @Override
    public void run() {
        // 第二步：关联标识    true--->运行   false--->停止
        int i = 0;
        while (flag){
            System.out.println("--->" + i++);
        }
    }

    // 第三步：对外提供方法改变标识
    public void terminate(){
        this.flag = false;
    }

    public static void main(String[] args) {
        TerminateThread tt = new TerminateThread();
        new Thread(tt).start();

        for(int i = 0; i < 99; i++){
            if(i == 88){
                tt.terminate(); // 线程的终止
                System.out.println("tt线程终止");
            }
            System.out.println("main--->" + i);
        }
    }

}
