package cn.summerki.mycollection;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * 增加remove方法
 * 最终完成Arrayist
 * @author summerki
 */
public class SummerkiArrayList05<E> {
    private Object[] elementData;
    private int size;

    // 定义默认值
    private static final int DEFAULT_CAPACITY = 10;

    //region 构造函数
    // 默认的构造器
    public SummerkiArrayList05(){
        elementData = new Object[DEFAULT_CAPACITY];
    }


    public SummerkiArrayList05(int capacity){
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

    public void remove(E element){
        //element,将它和所有元素挨个比较，获得第一个比较为true的，返回
        for(int i = 0; i < size; i++){
            if(element.equals(get(i))){ //容器中所有的比较操作都是用的equals而不是==
                remove(i);
            }
        }

    }

    public void remove(int index){
        int numMoved = elementData.length - index - 1;
        if(numMoved > 0){
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
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
        SummerkiArrayList05 summerkiArrayList05 = new SummerkiArrayList05(20);
        summerkiArrayList05.add("aa");
        summerkiArrayList05.add("bb");
        for(int i = 0; i < 400; i++){
            summerkiArrayList05.add("su" + i);
        }
        System.out.println(summerkiArrayList05.toString());
//        summerkiArrayList05.set("dd", -10);
        summerkiArrayList05.remove(4);
        summerkiArrayList05.remove("su4");

        System.out.println(summerkiArrayList05.toString());
    }
}
