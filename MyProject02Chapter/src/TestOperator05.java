/**
 * 字符串运算符
 * @author summerki
 */

public class TestOperator05 {
    public static void main(String[] args){
        String a = "3";
        int b = 4;
        int c = 5;
        System.out.println(a + b); // 输出 34， 此时+号变成字符串连接符
        System.out.println(b + c); // 输出 9

        System.out.println(a + b + c); // 输出 345
        System.out.println(b + c + a); // 输出 93

        char d = 'a';
        System.out.println(d + 4); // a->97 97+4=101
    }
}
