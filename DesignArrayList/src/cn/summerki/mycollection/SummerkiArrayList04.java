package cn.summerki.mycollection;

import javax.management.RuntimeErrorException;
import javax.management.RuntimeMBeanException;

/**
 * 增加set和get方法
 * 增加数组的边界检查
 * @author summerki
 */
public class SummerkiArrayList04<E> {
    private Object[] elementData;
    private int size;

    // 定义默认值
    private static final int DEFAULT_CAPACITY = 10;

    //region 构造函数
    // 默认的构造器
    public SummerkiArrayList04(){
        elementData = new Object[DEFAULT_CAPACITY];
    }


    public SummerkiArrayList04(int capacity){
        if(capacity < 0){
            throw new RuntimeException("容器的容量不能为负数");
        }else if(capacity == 0){
            elementData = new Object[DEFAULT_CAPACITY];
        }else{
            elementData = new Object[capacity];
        }
    }
    //endregion

    public void add(E element){
        //当size等于elementData.length的时候需要扩容
        if(size == elementData.length){
            // 扩容操作
            Object[] newArray = new Object[elementData.length + (elementData.length >> 1)];
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = newArray;
        }
        elementData[size++] = element;
    }

    public E get(int index){
        checkRange(index);
        return (E)elementData[index];
    }

    public void set(E element, int index){
        checkRange(index);
        elementData[index] = element;
    }

    public void checkRange(int index){
        //索引合法判断[0,size)
        if(index < 0 || index > size - 1){
            // 不合法
            throw new RuntimeException("索引不合法！" + index);
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        // 最后打印效果类似于；[a, b, c]
        sb.append("[");
        for(int i = 0; i < size; i++){
            if(i == size -1){
                sb.append(elementData[i]);
            }else{
                sb.append(elementData[i] + ", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        SummerkiArrayList04 summerkiArrayList04 = new SummerkiArrayList04(20);
        summerkiArrayList04.add("aa");
        summerkiArrayList04.add("bb");
        for(int i = 0; i < 400; i++){
            summerkiArrayList04.add("su" + i);
        }

        summerkiArrayList04.set("dd", -10);

        System.out.println(summerkiArrayList04.toString());
    }
}
