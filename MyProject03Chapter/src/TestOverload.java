/**
 * 测试方法的重载
 * @author summerki
 */

public class TestOverload {
    public static void main(String[] args) {
        System.out.println(add(3,5));
        System.out.println(add(3, 5, 10));
        System.out.println(add(3.0, 5));
        System.out.println(add(3, 5.0));
    }

    // 求和的方法
    public static int add(int a, int b){
        int sum = a + b;
        return sum;
    }

    // 方法名相同，参数个数不同，构成重载
    public static int add(int a, int b, int c){
        int sum = a + b + c;
        return sum;
    }

    // 方法名相同，参数类型不同，构成重载
    public static double add(double a, double b){
        double sum = a + b;
        return sum;
    }

    // 方法名相同，参数顺序不同，构成重载
    public static double add(int a, double b){
        double sum = a + b;
        return sum;
    }
}
