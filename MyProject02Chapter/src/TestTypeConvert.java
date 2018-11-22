/**
 * 测试类型转换
 * @author summerki
 */

public class TestTypeConvert {
    public static void main(String[] args){
        int a = 324;
        long b = a;
        double d = a;
//        a = b;
//        long e = 3.23F;
        float f =  23423L;

        // 特例
        byte b2 =   123;


        // 测试强制类型转换
        double x = 3.99;
        System.out.println((int)x);// 这里不是四舍五入，是直接省略小数后面的数
    }
}
