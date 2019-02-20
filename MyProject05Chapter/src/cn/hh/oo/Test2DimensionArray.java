package cn.hh.oo;

import java.util.Arrays;

/**
 * 测试二维数组
 * @author summerki
 */
public class Test2DimensionArray {
    public static void main(String[] args) {
        int[][] a = new int[3][]; // 定义一个长度为3的数组，每个数组的位置里面还是一个数组，但是长度可以随便，所以后面一个括号可以先不用写数字

        a[0] = new int[]{1, 2, 3};
        a[1] = new int[]{9, 8, 7};
        a[2] = new int[]{6};

        System.out.println(a[1][2]); // 输出 7
        System.out.println(Arrays.toString(a[2])); // 输出a数组第三个位置的数组
    }
}
