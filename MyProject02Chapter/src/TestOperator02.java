/**
 * 测试关系运算符
 * @author summerki
 */

public class TestOperator02 {

    public static void main(String[] args){
        int a =3;
        System.out.println(a == 3);
        System.out.println(a != 3);
        System.out.println(a < 5);

        char b = 'a';
        char c = 'c';
        System.out.println(b);// 此时会输出 a
        System.out.println(0 + b); // 输出 97
        System.out.println((int)b); // 输出 97
        System.out.println(b < c); // 注意，char可以用于比较，在比较时会自动转为数字
    }

}
