package cn.summerki.mycollection;

import com.sun.xml.internal.txw2.output.IndentingXMLStreamWriter;

/**
 * 新增插入节点
 * @author summerki
 */
public class SummerkiLinkedList04 {
    private Node first;
    private Node last;

    private int size;


    public void add(int index, Object obj){
        Node newNode = new Node(obj);
        Node temp = getNode(index);

        if(temp != null){
            Node up = temp.previous;

            up.next = newNode;
            newNode.previous = up;

            newNode.next = temp;
            temp.previous = newNode;
        }
    }

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

    public void remove(int index){
        Node temp = getNode(index);

        if(temp != null){
            Node up = temp.previous;
            Node down = temp.next;

            if(up != null){
                up.next = down;
            }
            if(down != null){
                down.previous = up;
            }

            //被删除的元素是第一个元素时
            if(index == 0){
                first = down;
            }
            //被删除的元素是最后一个元素时
            if(index == size - 1){
                last = up;
            }

            size--;
        }
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

        Node temp = getNode(index);

        return temp!=null?temp.element:null;
    }

    public Node getNode(int index){
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
        return temp;
    }

    public static void main(String[] args) {
        SummerkiLinkedList04 summerkiLinkedList04 = new SummerkiLinkedList04();

        summerkiLinkedList04.add("a");
        summerkiLinkedList04.add("b");
        summerkiLinkedList04.add("c");
        summerkiLinkedList04.add("d");
        summerkiLinkedList04.add("e");
        summerkiLinkedList04.add("f");

        System.out.println(summerkiLinkedList04.get(1));
        System.out.println(summerkiLinkedList04);
        summerkiLinkedList04.remove(0);
        System.out.println(summerkiLinkedList04);

        summerkiLinkedList04.add(3, "gg");
        System.out.println(summerkiLinkedList04);
    }
}
