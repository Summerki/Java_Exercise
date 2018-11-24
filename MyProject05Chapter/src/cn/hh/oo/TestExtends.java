package cn.hh.oo;

/**
 * 测试继承
 * @author summerki
 */
public class TestExtends {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.name = "summerki";
        stu.height = 180;
        stu.rest();

        Student stu02 = new Student("xx", 180, "oo");
    }
}

class Person{
    String name;
    int height;

    public void rest(){
        System.out.println("休息一会儿");
    }
}

class Student extends Person{
//    String name;
//    int height;
    String major;

    public void study(){
        System.out.println("学习");
    }

//    public void rest(){
//        System.out.println("休息一会儿");
//    }

    public Student(){
    }

    public Student(String name, int height, String major){
        this.name = name;
        this.height = height;
        this.major = major;
    }

}
