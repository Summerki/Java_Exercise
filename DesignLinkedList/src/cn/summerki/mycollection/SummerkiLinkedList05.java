package cn.summerki.mycollection;

/**
 * 新增小封装、增加泛型
 * @author summerki
 */
public class SummerkiLinkedList05<E> {
    private Node first;
    private Node last;

    private int size;


    public void add(int index, E element){
        checkRange(index);
        Node newNode = new Node(element);
        Node temp = getNode(index);

        if(temp != null){
            Node up = temp.previous;

            up.next = newNode;
            newNode.previous = up;

            newNode.next = temp;
            temp.previous = newNode;
        }
    }

    public void add(E element){
        Node node = new Node(element);
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
        checkRange(index);
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

    public E get(int index){

        checkRange(index);
        Node temp = getNode(index);

        return temp!=null?(E)temp.element:null;
    }

    public void checkRange(int index){
        if(index < 0 || index > size - 1){
            throw new RuntimeException("索引数字不合法：" + index);
        }
    }

    private Node getNode(int index){
        checkRange(index);
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
        SummerkiLinkedList05<String> summerkiLinkedList05 = new SummerkiLinkedList05<String>();

        summerkiLinkedList05.add("a");
        summerkiLinkedList05.add("b");
        summerkiLinkedList05.add("c");
        summerkiLinkedList05.add("d");
        summerkiLinkedList05.add("e");
        summerkiLinkedList05.add("f");

        System.out.println(summerkiLinkedList05.get(1));
        System.out.println(summerkiLinkedList05);
        summerkiLinkedList05.remove(0);
        System.out.println(summerkiLinkedList05);

        summerkiLinkedList05.add(3, "gg");
        System.out.println(summerkiLinkedList05);
    }
}
