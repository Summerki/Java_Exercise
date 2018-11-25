package cn.hh.oo;

import java.util.Arrays;

/**
 * 自己想出来的垃圾排序算法
 * @author summerki
 */
public class TestBubbleSort {
    public static void main(String[] args) {
        int[] values = { 3, 1, 6, 2, 9, 0, 7, 4, 5, 8 };
        int[] newValues = BubbleSort(values);
        System.out.println(Arrays.toString(newValues));
    }

    /**
     * 这不是冒泡排序，我每次选取第一个值开始依次和后面的值开始比较选出最小的值，然后i++再继续
     * @param originalArray
     * @return
     */
    public static int[] BubbleSort(int[] originalArray){
        for(int i = 0; i < originalArray.length; i++){
            for(int j = 0; j < originalArray.length - i; j++){
                if(originalArray[i] > originalArray[j + i]){
                    int temp = originalArray[i];
                    originalArray[i] = originalArray[j + i];
                    originalArray[j + i] = temp;
                }
            }
        }
        return originalArray;
    }
}
