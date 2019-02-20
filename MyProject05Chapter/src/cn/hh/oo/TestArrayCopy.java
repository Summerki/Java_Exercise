package cn.hh.oo;

/**
 * 测试数组的拷贝
 * @author summerki
 */
public class TestArrayCopy {
    public static void main(String[] args) {
        String[] str = {"s", "u", "m", "m", "e", "r", "k", "i"};
        System.arraycopy(str, 2, str, 3, 4);
        for(int i = 0; i < str.length; i++){
            System.out.println(i + "->" + str[i]);
        }
    }



}
