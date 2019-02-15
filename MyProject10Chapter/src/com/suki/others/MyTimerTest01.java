package com.suki.others;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 任务调度：timer和timertask类
 */
public class MyTimerTest01 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        // 执行任务
//        timer.schedule(new MyTask(), 10000); // 先过10s再执行；执行任务一次
//        timer.schedule(new MyTask(), 10000, 200);// 延时1s执行，之后每隔200ms执行一次；执行多次
        Calendar cal = new GregorianCalendar(2099, 12, 31, 21, 53, 54);
        timer.schedule(new MyTask(), cal.getTime(), 200);// 到指定时间开始执行，之后再每隔200ms执行一次
    }
}
// 任务类
class MyTask extends TimerTask{
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println("防控大脑休息一会");
        }
        System.out.println("----end----");
    }
}