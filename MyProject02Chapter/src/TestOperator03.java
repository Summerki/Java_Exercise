/**
 * 逻辑运算符
 * @author summerki
 */

public class TestOperator03 {

    public static void main(String[] args){
        boolean b1 = true;
        boolean b2 = false;
        System.out.println(b1 & b2);
        System.out.println(b1 | b2);
        System.out.println(b1 ^ b2);

        // 短路
        // int c = 3 / 0; // 报异常
        boolean b3 = 1 > 2 && 2 < (3 / 0);
        System.out.println(b3); // 输出false， 说明短路判断只要前面符合条件后面就不会再判断了
    }

}
