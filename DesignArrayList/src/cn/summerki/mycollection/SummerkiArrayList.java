package cn.summerki.mycollection;

/**
 * 自定义设计一个ArrayList
 * @author summerki
 */
public class SummerkiArrayList {

    private Object[] elementData;
    private int size;

    // 定义默认值
    private static final int DEFAULT_CAPACITY = 10;

    //region 构造函数
    // 默认的构造器
    public SummerkiArrayList(){
        elementData = new Object[DEFAULT_CAPACITY];
    }


    public SummerkiArrayList(int capacity){
        elementData = new Object[capacity];
    }
    //endregion

    public void add(Object obj){
        elementData[size++] = obj;
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
        SummerkiArrayList summerkiArrayList = new SummerkiArrayList(20);
        summerkiArrayList.add("aa");
        summerkiArrayList.add("bb");

        System.out.println(summerkiArrayList.toString());
    }

}
