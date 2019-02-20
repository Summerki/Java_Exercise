package cn.summerki.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试HashMap的使用
 * @author summerki
 */
public class TestMap {
    public static void main(String[] args) {
        Map<Integer, String> m1 = new HashMap<>();
        m1.put(1, "One");
        m1.put(2, "Two");
        m1.put(3, "Three");

        System.out.println(m1);
        System.out.println(m1.get(1));

        System.out.println(m1.size());
        System.out.println(m1.isEmpty());
        System.out.println(m1.containsKey(2));
        System.out.println(m1.containsValue("Four"));

        Map<Integer, String> m2 = new HashMap<>();
        m2.put(4, "四");
        m2.put(5, "五");

        m1.putAll(m2);
        System.out.println(m1);
    }

}
