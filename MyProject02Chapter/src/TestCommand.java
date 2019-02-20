/**
 * 用来测试注释的用法
 * @author summerki
 */

public class TestCommand {

    // 原来在java里对于函数的注释是下面这样写的
    /**
     * 这是程序的入口
     * @param args 参数
     */
    public static void main(String[] args/* args是参数名，可以更改*/){
        System.out.println("测试注释"); // 这是打印语句

        /*

        这是多行注释

         */
    }
}
