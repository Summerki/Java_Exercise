package cn.hh.oo;

/**
 * 测试String类
 */
public class TestString {
    public static void main(String[] args) {
        String str = "abc";
        String str2 = "18" + 19; // 这里加号默认变成字符串连接符，不再是加号的作用 ，输出 1819
        System.out.println(str2);

        System.out.println("##############");
        String str3 = "summerki";
        String str4 = "summerki";
        String str5 = new String("summerki");
        System.out.println(str3 == str4); // 返回true，因为字符串常量池的原因
        System.out.println(str3 == str5); // 返回false，因为str5是new出来的一个新的对象
        String str6 = str3.intern();

        // 建议，通常比较字符串时推荐使用equals
        System.out.println(str5.equals(str3)); // 返回true
    }
}
