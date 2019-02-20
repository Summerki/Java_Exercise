package cn.summerki.collections;

/**
 * 测试泛型02
 * @author summerki
 */
public class TestCollection02 {
    public static void main(String[] args) {
        MyCollection<String> mc = new MyCollection<String>();
        mc.set("summerki", 0);
        String b = mc.get(0);
    }
}

class MyCollection<E>{
    Object[] objs = new Object[5];


    public void set(E e, int index){
        objs[index] = e;
    }

    public E get(int index){
        return (E)objs[index];
    }
}