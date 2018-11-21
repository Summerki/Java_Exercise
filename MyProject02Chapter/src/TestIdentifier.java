/**
 * 测试标识符的用法
 * @author summerki
 */

public class TestIdentifier {
    public static void main(String[] args){
        int a123 = 1;
        // int 123abc  = 1; // 数字不能开头
        int $a = 3;
        int _abc = 1;
        // int #abc = 1; //

        int 年龄 = 18;// 可以使用汉字，但是一般不建议

        // int class = 1;// 关键字不能作为标识符
    }
}
