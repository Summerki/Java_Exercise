package cn.summerki.mycollection;

/**
 * 增加get方法
 * @author summerki
 */
public class SummerkiLinkedList02 {
    private Node first;
    private Node last;

    private int size;


    public void add(Object obj){
        Node node = new Node(obj);
        //[] => ["a"]
        if(first == null){
            first = node;
            last = node;
        }else{ // ["a","b"] => ["a","b","c"]
            node.previous = last;
            node.next = null;

            last.next = node;
            last = node;
        }
        size++;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node temp = first;
        while(temp != null){
//            System.out.println(temp.element);
            sb.append(temp.element + ",");
            temp = temp.next;
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public Object get(int index){
        if(index < 0 || index > size - 1){
            throw new RuntimeException("索引数字不合法：" + index);
        }


        Node temp = null;
        // 优化：查询时可以从头开始查找也可以从尾部开始查找
        if(index <= (size >> 1)){
            temp = first;
            for(int i = 0; i < index; i++){
                temp = temp.next;
            }
        }else{
            temp = last;
            for(int i = size - 1; i > index; i--){
                temp = temp.previous;
            }
        }
        return temp.element;
    }

    public static void main(String[] args) {
        SummerkiLinkedList02 summerkiLinkedList02 = new SummerkiLinkedList02();

        summerkiLinkedList02.add("a");
        summerkiLinkedList02.add("b");
        summerkiLinkedList02.add("c");

        System.out.println(summerkiLinkedList02.get(1));

        System.out.println(summerkiLinkedList02);
    }
}
