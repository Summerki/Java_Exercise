package cn.summerki.collections;

import java.util.HashSet;
import java.util.Set;

/**
 * 测试HashSet
 */
public class TestHashSet {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();

        set1.add("aa");
        set1.add("bb");
        set1.add("aa"); // 不会被添加,因为set是不可重复的

        System.out.println(set1);
    }
}
