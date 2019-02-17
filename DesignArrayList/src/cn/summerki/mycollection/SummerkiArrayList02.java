package cn.summerki.mycollection;

/**
 * 自定义一个ArrayList
 * 增加泛型
 * @author summerki
 */
public class SummerkiArrayList02<E> {
    private Object[] elementData;
    private int size;

    // 定义默认值
    private static final int DEFAULT_CAPACITY = 10;

    //region 构造函数
    // 默认的构造器
    public SummerkiArrayList02(){
        elementData = new Object[DEFAULT_CAPACITY];
    }


    public SummerkiArrayList02(int capacity){
        elementData = new Object[capacity];
    }
    //endregion

    public void add(E element){
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
        SummerkiArrayList02 summerkiArrayList02 = new SummerkiArrayList02(20);
        summerkiArrayList02.add("aa");
        summerkiArrayList02.add("bb");

        System.out.println(summerkiArrayList02.toString());
    }
}
