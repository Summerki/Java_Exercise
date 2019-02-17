/**
 * 测试算术运算符
 * @author summerki
 */

public class TestOperator01 {

    public static void main(String[] args){
//        byte a = 1;
//        int b = 2;
//        long b2 = 3;
//        // byte c = a + b; // 报错
//        // int c2 = b2 + b; // 报错
//
//        //“余数”符号和左边操作数相同
//        System.out.println(10%-3);

        // 测试自增和自减
        int a = 3;
        int b = a++;   //执行完后,b=3。先给b赋值，再自增。
        System.out.println("a="+a+"\nb="+b);
        a = 3;
        b = ++a;   //执行完后,c=5。a先自增，再给c赋值
        System.out.println("a="+a+"\nb="+b);
    }

}
