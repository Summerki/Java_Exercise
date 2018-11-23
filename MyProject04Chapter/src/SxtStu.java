import javax.xml.transform.sax.SAXTransformerFactory;

/**
 * 第一个类
 * @author summerki
 */

public class SxtStu {

    // 属性fields
    int id;
    String name;
    int age;

    Computer comp;


    // 方法
    void study(){
        System.out.println("认真学习" + comp.brand);
    }

    void play(){
        System.out.println("玩游戏");
    }

    // 构造方法，用于创建这个类的对象。无参的构造方法可以由系统自动创建
    SxtStu(){   // 构造函数的方法名必须和类名一模一样

    }

    //程序执行的入口，必须要有
    public static void main(String[] args) {
        SxtStu stu = new SxtStu(); // 创建一个对象

        stu.id = 1001;
        stu.name = "summerki";
        stu.age = 18;

        Computer c1 = new Computer();
        c1.brand = "联想";

        stu.comp = c1;

        stu.play();
        stu.study();

    }
}


// 一个java文件里可以有多个类，但是只能允许1个被public修饰的类
class Computer{
    String brand; // 品牌
}
