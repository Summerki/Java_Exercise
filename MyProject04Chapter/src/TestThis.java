/**
 * 测试this
 * @author summerki
 */

public class TestThis {
    int a, b, c;

    // 说明一点，如果你自己写了构造函数java程序就不会默认产生构造函数了
    TestThis(int a, int b){
        this.a = a;
        this.b = b;  // this代表当前的对象
    }

    TestThis(int a, int b, int c){
        this(a, b); // 想要在多个重写的构造函数中某一个调用另一个构造函数，就用这种形式，而且必须位于第一句
        this.c = c;
    }

    void sing(){

    }

    void eat(){
        this.sing();
        System.out.println("吃饭");
    }

    public static void main(String[] args) {
        TestThis hi = new TestThis(2, 3);
        hi.eat();
    }
}
