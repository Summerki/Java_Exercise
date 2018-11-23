import org.jcp.xml.dsig.internal.SignerOutputStream;

import java.sql.SQLOutput;

/**
 * 测试递归
 * @author summerki
 */

public class TestRecursion {
    public static void main(String[] args) {
        // 使用递归计算n的阶乘
        long d1 = System.currentTimeMillis();// 这是得出当前时间的函数
        System.out.println("10" + "的阶乘是" + factorial(10));
        long d2 = System.currentTimeMillis();
        System.out.println("递归费时" + (d2 - d1));


        // 使用for循环计算阶乘
        long d3 = System.currentTimeMillis();
        int sum = 1;
        for(int i = 1; i <= 10; i++){
            sum = sum * i;
        }
        long d4 = System.currentTimeMillis();
        System.out.println("10的阶乘是：" + sum);
        System.out.println("for循环递归费时" + (d4 - d3));
    }



    // 求阶乘的方法
    static long factorial(int n){
        if(n == 1){
            return 1;
        }else{
            return n * factorial(n - 1);
        }
    }
}
