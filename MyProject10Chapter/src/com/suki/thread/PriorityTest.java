package com.suki.thread;

/**
 * @author Summerki
 */
public class PriorityTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getPriority()); // 输出5  因为默认优先级是5
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY); // 将main线程优先级设为MAX
        System.out.println(Thread.currentThread().getPriority()); // 由于设置了MAX，所以这里会输出10
    }
}
