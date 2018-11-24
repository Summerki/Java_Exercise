package cn.hh.oo;

/**
 * 测试多态
 * @author summerki
 */
public class TestPolym {
    public static void main(String[] args) {
        Animal a1 = new Cat();
        animalCry(a1);

        Animal a2 = new Dog();
        animalCry(a2);

    }

    static void animalCry(Animal a){
        a.shut();
    }
}

class Animal{
    public void shut(){
        System.out.println("叫了一声");
    }
}

class Dog extends Animal{
    public void shut(){
        System.out.println("旺旺旺");
    }
    public void seeDoor(){
        System.out.println("看门中...");
    }
}

class Cat extends Animal{
    public void shut(){
        System.out.println("喵喵喵");
    }
}



