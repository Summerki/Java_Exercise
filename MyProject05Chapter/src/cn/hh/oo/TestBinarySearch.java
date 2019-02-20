package cn.hh.oo;

import java.util.Arrays;

/**
 * 测试二分查找
 * @author summerki
 */
public class TestBinarySearch {
    public static void main(String[] args) {
        int[] arr = { 30,20,50,10,80,9,7,12,100,40,8};
        binarySearch(arr, 100);
    }

    public static void binarySearch(int[] searchArray, int searchKeyWord){
        boolean bSearch = false;
        for(int i = 0; i < searchArray.length; i++){
            if(searchKeyWord == searchArray[i])
            {
                System.out.println(Arrays.toString(searchArray) + "中" + searchKeyWord + "位置是：" + (i + 1));
                bSearch = true;
            }


        }
        if(bSearch == false){
            System.out.println("未找到相关结果！");
        }
    }
}
