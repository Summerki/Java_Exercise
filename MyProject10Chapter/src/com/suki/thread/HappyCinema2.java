package com.suki.thread;

import java.util.ArrayList;
import java.util.List;

public class HappyCinema2 {
    public static void main(String[] args) {
        // 可用位置
        List<Integer> avaliable = new ArrayList<Integer>();
        avaliable.add(1);
        avaliable.add(2);
        avaliable.add(3);
        avaliable.add(6);
        avaliable.add(7);

        // 顾客需要的位置
        List<Integer> seats1 = new ArrayList<Integer>();
        seats1.add(1);
        seats1.add(2);
        List<Integer> seats2 = new ArrayList<Integer>();
        seats2.add(4);
        seats2.add(5);
        seats2.add(6);

        SxtCinema c = new SxtCinema(avaliable, "happy sxt");
        new Thread(new HappyCustomer(c,seats1),"老高").start();
        new Thread(new HappyCustomer(c,seats2),"老裴").start();
    }
}

// 顾客
class HappyCustomer implements Runnable{
    SxtCinema cinema;
    List<Integer> seats;

    public HappyCustomer(SxtCinema cinema, List<Integer> seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        synchronized (cinema){
            boolean flag = cinema.bookTickets(seats);
            if(flag){
                System.out.println("出票成功" + Thread.currentThread().getName() + "-<位置为:" + seats);
            }else {
                System.out.println("出票失败" + Thread.currentThread().getName() + "位置不够");
            }
        }
    }
}

// 影院
class SxtCinema{
    List<Integer> available; // 可用位置
    String name; // 名称

    public SxtCinema(List<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }

    //购票 seats为准备订购的座位数
    public boolean bookTickets(List<Integer> seats){
        System.out.println("欢迎光临" + this.name + "当前可用位置为:" + available);
        System.out.println("可用位置为:" + available);
        List<Integer> copy = new ArrayList<Integer>();
        copy.addAll(available);

        // 相减
        copy.removeAll(seats);
        // 判断大小
        if(available.size() - copy.size() != seats.size()){
            return false;
        }
        // 成功
        available = copy;
        return true;
    }
}
