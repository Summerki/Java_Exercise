import org.omg.CORBA.ARG_OUT;

/**
 * 测试方法的基本使用
 * @author summerki
 */

public class TestMethod {
    public static void main(String[] args) {

        // 注意：有无static最明显的区别
        // 有static可以直接被调用
        // 无static需要new一个对象出来再进行调用

        // 通过对象调用普通方法
        TestMethod tm = new TestMethod();
        tm.printSxt();
        int c = tm.add(30, 40, 50) + 1000;
        System.out.println(c);
    }

    void printSxt(){
        System.out.println("hello");
        System.out.println("world");
    }

    int add(int a, int b, int c){
        int sum = a + b + c;
        System.out.println(sum);
        return sum; // return两个作用：1结束方法运行 2返回值
    }
}
