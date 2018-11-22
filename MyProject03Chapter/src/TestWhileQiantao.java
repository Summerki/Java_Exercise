/**
 * 测试嵌套循环
 * @author summerki
 */

public class TestWhileQiantao {
    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++){
            for(int j = 1; j <= 5; j++){
                System.out.print(i);// print代表不会换行输出！！！
                System.out.print('\t');
            }
            System.out.println();
        }

        // 打印九九乘法表
        for(int i = 0; i <= 9; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(j + "*" + i + "=" + i*j + "\t");
            }
            System.out.println();
        }
    }
}
