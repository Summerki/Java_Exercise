import java.util.Scanner;

/**
 * 测试键盘输入
 * @author summerki
 */

public class TestScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入你的名字：");
        String name = scanner.nextLine();
        System.out.println("请输入你的爱好：");
        String favor = scanner.nextLine();
        System.out.println("请输入你的年龄：");
        int age = scanner.nextInt();

        System.out.println("姓名：" + name + "爱好：" + favor + "年龄：" + age);

    }
}
