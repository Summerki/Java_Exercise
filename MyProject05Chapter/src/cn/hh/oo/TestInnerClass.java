package cn.hh.oo;

/**
 * 测试内部类
 * @author summerki
 */
public class TestInnerClass {
    public static void main(String[] args) {
        // 实例化Inner对象
        Outer.Inner inner = new Outer().new Inner();
        inner.show();

        // 实例化Outer对象
        Outer outer = new Outer();
        outer.show();
    }

}

// 外部类Outer
class Outer{
    private int age = 10;
    public void show(){
        System.out.println(age);
    }

    // 内部类
    public class Inner{
        // 内部类可以声明与外部类同名的属性方法
        private int age = 20;
        public void show(){
            System.out.println(age);
        }
    }
}