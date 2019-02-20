package cn.summerki.mycollection;

/**
 * 增加数组扩容功能
 * @author summerki
 */
public class SummerkiArrayList03<E> {
    private Object[] elementData;
    private int size;

    // 定义默认值
    private static final int DEFAULT_CAPACITY = 10;

    //region 构造函数
    // 默认的构造器
    public SummerkiArrayList03(){
        elementData = new Object[DEFAULT_CAPACITY];
    }


    public SummerkiArrayList03(int capacity){
        elementData = new Object[capacity];
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
        SummerkiArrayList03 summerkiArrayList03 = new SummerkiArrayList03(20);
        summerkiArrayList03.add("aa");
        summerkiArrayList03.add("bb");
        for(int i = 0; i < 400; i++){
            summerkiArrayList03.add("su" + i);
        }

        System.out.println(summerkiArrayList03.toString());
    }
}
