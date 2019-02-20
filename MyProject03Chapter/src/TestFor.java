/**
 * 测试for循环
 * @author summerki
 */

public class TestFor {
    public static void main(String[] args) {
        // 计算1+2+...+100 5050

        int sum = 0;
        for (int i = 0; i <= 100; i++)
        {
            sum = sum + i;
        }
        System.out.println("最终值为：" + sum);
    }
}
