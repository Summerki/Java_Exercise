package cn.summerki.collections;

import sun.security.util.AuthResources_it;
import sun.text.resources.it.JavaTimeSupplementary_it;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 测试Collection接口中的方法
 * @author summerki
 */
public class TestList {
    public static void main(String[] args) {
        //region 基本用法1
        Collection<String> c = new ArrayList<String>();

        System.out.println(c.size());
        System.out.println(c.isEmpty());

        c.add("第一");
        c.add("第二");
        System.out.println(c);
        System.out.println(c.size());

        System.out.println(c.contains("第一"));

        Object[] objs = c.toArray();
//        for(int i = 0; i < objs.length; i++){
//            System.out.println(objs[i]);
//        }
        System.out.println(Arrays.toString(objs));

        c.remove("第一");
        System.out.println(c);

        c.clear();
        System.out.println(c.size());
        //endregion

        System.out.println("##################");

        //region 基本用法2
        List<String> list01 = new ArrayList<String>();
        list01.add("aa");
        list01.add("bb");
        list01.add("cc");

        List<String> list02 = new ArrayList<String>();
        list02.add("aa");
        list02.add("dd");
        list02.add("ee");

//        System.out.println("list01:" + list01);
//        list01.addAll(list02);
//        System.out.println("list01:" + list01);

//        System.out.println("list01:" + list01);
//        list01.removeAll(list02);
//        System.out.println("list01:" + list01);

        System.out.println("list01:" + list01);
        list01.retainAll(list02);
        System.out.println("list01:" + list01);

        System.out.println(list01.containsAll(list02));
        //endregion

        System.out.println("##################");

        //region List的基本用法

        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        list.add(2, "summerki");
        list.remove(2);

        System.out.println(list);

        list.set(2, "summerki"); // 注意set和add的区别
        System.out.println(list);

        System.out.println(list.get(2));

        System.out.println(list.indexOf("B"));

        //endregion
    }
}


