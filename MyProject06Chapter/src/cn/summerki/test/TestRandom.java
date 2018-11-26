package cn.summerki.test;

import java.util.Random;

/**
 * 测试Random类
 * @author summerki
 */
public class TestRandom {
    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println(rand.nextDouble());
        System.out.println(20 + rand.nextInt(10));
    }
}
