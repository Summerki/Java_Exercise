/**
 * 测试常量
 * @author summerki
 */

public class TestConstant {

    public static void main(String[] args){
        int age = 18;
        String name = "summerki"; // 注意String是大写的S
        name = "summerki_";

        final double PI = 3.14;
        // PI = 3.15; // 编译错误，常量无法再被赋值

        System.out.println(name);
    }

}
