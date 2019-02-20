package cn.summerki.mycollection;

/**
 * 自定义一个链表
 * @author summerki
 */
public class SummerkiLinkedList01 {

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



    public static void main(String[] args) {
        SummerkiLinkedList01 summerkiLinkedList01 = new SummerkiLinkedList01();

        summerkiLinkedList01.add("a");
        summerkiLinkedList01.add("b");
        summerkiLinkedList01.add("c");

        System.out.println(summerkiLinkedList01);
    }


}
