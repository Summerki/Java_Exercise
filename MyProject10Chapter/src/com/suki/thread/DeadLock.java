package com.suki.thread;

/**
 * 死锁：过多的同步可能会造成互相不释放资源
 * 从而相互等待，一般发生于同步中持有多个对象的锁
 */
public class DeadLock {
}

// 口红
class Lipstick{

}

// 镜子
class Mirror{
    public static void main(String[] args) {
        Markup g1 = new Markup(1, "A");
        Markup g2 = new Markup(0, "B");
        g1.start();
        g2.start();
    }
}

// 化妆
class Markup extends Thread{
    // 加静态表示一份
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    // 选择 0拿口红 1拿镜子
    int choice;
    // 名字
    String girl;

    public Markup(int choice, String girl) {
        this.choice = choice;
        this.girl = girl;
    }

    @Override
    public void run() {
        super.run();
        // 化妆
        markup();
    }
    // 相互持有对方的对象锁-->可能造成死锁
    private void markup(){
        if(choice == 0){
            synchronized (lipstick){ // 获得口红的锁
                System.out.println(this.girl + "获得口红");
                // 1s后想拥有镜子的锁
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (mirror){
                    System.out.println(this.girl + "获得镜子");
                }
            }
        }else {
            synchronized (mirror){ // 获得镜子的锁
                System.out.println(this.girl + "获得镜子");
                // 2s后想拥有口红的锁
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lipstick){
                    System.out.println(this.girl + "获得口红");
                }
            }
        }
    }
}
