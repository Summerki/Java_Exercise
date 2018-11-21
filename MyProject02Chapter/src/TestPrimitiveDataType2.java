import java.math.*;

/**
 * 测试浮点型
 * @author summerki
 */

public class TestPrimitiveDataType2 {

    public static void main(String[] args){
        float a = 3.14F;
        double b = 6.28D;// D可加可不加

        double c = 628E-2;

        System.out.println(c);

        // 浮点数是不精确的，一定不要用于比较！
        float f = 0.1f;
        double d = 1.0 / 10;
        System.out.println(f == d);// 可以知道这里的结果为：false!!!

        float d1 = 423432423f;
        float d2 = d1 + 1;
        if(d1 == d2){
            System.out.println("d1 == d2"); // 这里会输出这个（你敢信）
        }else{
            System.out.println("d1 != d2");
        }

        /*上面可以知道浮点型比较大小不靠谱
          如果非要比较，使用精确的浮点运算，可以使用BigInterger和BigDecimal
         */
        BigDecimal bd = BigDecimal.valueOf(1.0);
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        System.out.println(bd);// 0.5
        System.out.println(1.0 - 0.1 - 0.1 - 0.1 - 0.1 - 0.1);// 0.5000000000000001

        BigDecimal bd2 = BigDecimal.valueOf(0.1);
        BigDecimal bd3 = BigDecimal.valueOf(1.0 / 10);
        System.out.println(bd2.equals(bd3));// 这样就是 true 了
    }

}
