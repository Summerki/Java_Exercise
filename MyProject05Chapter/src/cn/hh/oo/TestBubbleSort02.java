package cn.hh.oo;

import java.util.Arrays;

/**
 * 测试冒泡排序
 * @author summerki
 */
public class TestBubbleSort02 {
    public static void main(String[] args) {
        int[] values = { 3, 1, 6, 2, 9, 0, 7, 4, 5, 8 };
        int[] newValues = bubbleSort(values);
        System.out.println(Arrays.toString(newValues));
    }

    /**
     * 冒泡排序算法，每次选出最大的值
     * @param originalArray
     * @return
     */
    public static int[] bubbleSort(int[] originalArray){
        for(int i = 0;i < originalArray.length; i++){
            for(int j = 0; j < originalArray.length - 1 - i; j++){
                if(originalArray[j] > originalArray[j + 1]){
                    int temp = originalArray[j];
                    originalArray[j] = originalArray[j + 1];
                    originalArray[j + 1] = temp;
                }
            }
        }
        return originalArray;
    }
}

