/**
 * 测试while循环
 * @author summerki
 */

public class TestWhile {
    public static void main(String[] args) {
        // 计算1+2+...+100的和 5050
        int i = 1;
        int sum = 0;
        while(i <= 100){
            sum = sum + i;
            i++;
        }
        System.out.println("最后的值为：" + sum);
    }
}
