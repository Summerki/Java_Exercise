/**
 * 测试字符类型和布尔类型
 * @author summerki
 */

public class TestPrimitiveDataType3 {

    public static void main(String[] args){
        char a = 'T';
        char b = '和';
        char c = '\u0061';
        System.out.println(c);
        char d = '\n';
        System.out.println(d);

        System.out.println('a' + 'b'); // 输出 195
        System.out.println("" + 'a' + 'b');// 输出 ab
        // 转义字符
        System.out.println("" + 'a' + '\'' + 'b'); // 输出 a'b

        // String 就是字符序列
        String e = "123";

        // 测试布尔类型
        boolean man = true;
        if(man){    // 极端不推荐：man == true
            System.out.println("男性");
        }
    }

}
