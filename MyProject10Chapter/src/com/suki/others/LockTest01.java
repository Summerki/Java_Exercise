package com.suki.others;

import java.awt.geom.FlatteningPathIterator;

/**
 * 自己实现不可重入锁：锁不可以延续使用
 */
public class LockTest01 {
    Lock lock = new Lock();
    public void a() throws InterruptedException {
        lock.lock();
        doSomething();
        lock.unlock();
    }
    public void doSomething() throws InterruptedException {
        lock.lock();
        //......
        lock.unlock();
    }
    public static void main(String[] args) throws InterruptedException {
        LockTest01 lockTest01 = new LockTest01();
        lockTest01.a();
        lockTest01.doSomething();
    }
}
// 实现一个锁不要想太复杂，其实就是写一个类
// 不可重入锁
class Lock{
    // 是否占用
    private boolean isLocked = false;
    // 使用锁
    public synchronized void lock() throws InterruptedException {
        while(isLocked){
            wait();
        }
        isLocked = true;
    }
    // 释放锁
    public synchronized void unlock(){
        isLocked = false;
        notify();
    }
}