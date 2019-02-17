package com.suki.others;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁：锁可以延续使用+计数器
 * 下面写的锁就是ReentrantLock的原型
 */
public class LockTest02 {
    ReLock lock = new ReLock();
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
        LockTest02 lockTest01 = new LockTest02();
        lockTest01.a();
        lockTest01.doSomething();
    }
}

// 可重入锁
class ReLock{
    // 是否占用
    private boolean isLocked = false;
    private Thread lockedBy = null; // 存储线程
    private int holdCount = 0; // 锁的个数的计数器

    public int getHoldCount() {
        return holdCount;
    }

    // 使用锁
    public synchronized void lock() throws InterruptedException {
        while(isLocked && lockedBy != Thread.currentThread()){
            wait();
        }
        isLocked = true;
        lockedBy = Thread.currentThread();
        holdCount++;
    }
    // 释放锁
    public synchronized void unlock(){
        if(Thread.currentThread() == lockedBy){
            holdCount--;
            if(holdCount == 0){
                isLocked = false;
                notify();
                lockedBy = null;
            }
        }
    }
}