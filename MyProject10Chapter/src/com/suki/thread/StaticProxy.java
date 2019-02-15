package com.suki.thread;

/**
 * @author Summerki
 */
public class StaticProxy {
    public static void main(String[] args) {
        new WeddingCompany(new You()).happyMarry();
        // 对比使用线程时：new Thread(线程对象).start()
    }
}

interface Marry{
    void happyMarry();
}

// 真实角色
class You implements Marry{
    @Override
    public void happyMarry() {
        System.out.println("你终于结婚了");
    }
}

// 代理角色
class WeddingCompany implements Marry{
    // 这里面必须有一个真实角色
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        ready();
        this.target.happyMarry();
        after();
    }

    private void  ready(){
        System.out.println("结婚前");
    }

    private void after(){
        System.out.println("结婚后");
    }
}
