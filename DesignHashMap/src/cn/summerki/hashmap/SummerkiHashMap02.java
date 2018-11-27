package cn.summerki.hashmap;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil;

import javax.swing.undo.CannotUndoException;

/**
 * 新增toString()方法
 */
public class SummerkiHashMap02 {
    Node[] table; // 位桶数组. bucket array
    int size;     // 存放的键值对个数

    public SummerkiHashMap02(){
        table = new Node[16]; // 长度一般定义成2的整数次幂
    }

//    public void put(Object key, Object value){
//
//        // 如果要完善还需要考虑数组扩容的问题
//
//        // 定义新的节点对象
//        Node newNode = new Node();
//        newNode.hash = myHash(key.hashCode(), table.length);
//        newNode.key = key;
//        newNode.value = value;
//        newNode.next = null;
//
//        Node temp = table[newNode.hash];
//
//        Node iterLast = null; // 正在遍历的最后一个元素
//
//        boolean keyRepeat = false;
//
//        if(temp == null){
//            // 此处代表数组元素为空，则直接将新节点放进去
//            table[newNode.hash] = newNode;
//        }else{
//            // 此处数组元素不为空，则遍历对应链表
//            while(temp != null){
//                // 判断key如果重复，则覆盖
//                if(temp.key.equals(key)){
////                    System.out.println("key重复");
//                    keyRepeat = true;
//                    temp.value = value; // 只是覆盖value即可。其他的值（hash、value、next）保持不变
//                    break;
//                }else{
//                    // key不重复，则遍历下一个
//                    iterLast = temp;
//                    temp = temp.next;
//                }
//            }
//            if(!keyRepeat){ // 没有发生key重复的情况下，则添加到链表的最后
//                iterLast.next = newNode;
//            }
//        }
//    }

    @Override
    public String toString(){
        //{1:aa,2:bb}这种形式
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        // 遍历bucket数组
        for(int i = 0; i < table.length; i++){
            Node temp = table[i];
            // 遍历链表
            while(temp != null){
                sb.append(temp.key + ":" + temp.value + ",");
                temp = temp.next;
            }
        }
        sb.setCharAt(sb.length() -1, '}');
        return sb.toString();
    }

    public static void main(String[] args) {
        SummerkiHashMap02 summerkiHashMap02 = new SummerkiHashMap02();

//        summerkiHashMap02.put(10, "aa");
//        summerkiHashMap02.put(20, "bb");
//        summerkiHashMap02.put(30, "cc");
//
//        summerkiHashMap02.put(20, "ss");// 测试重写，有没有覆盖
//
//        summerkiHashMap02.put(53, "gg"); // 这3个数据的hash值相同，用来测试覆盖
//        summerkiHashMap02.put(69, "hh");
//        summerkiHashMap02.put(85, "kk");

        System.out.println(summerkiHashMap02.toString());
    }


    public int myHash(int v, int length){
        System.out.println("hash in myHash:" + (v&(length - 1))); // 直接位运算，效率高
        System.out.println("hash in myHash:" + (v%(length - 1))); // 取模运算，效率低
        return v&(length - 1);
    }
}
