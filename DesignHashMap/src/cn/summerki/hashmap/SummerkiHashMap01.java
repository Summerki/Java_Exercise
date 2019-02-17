package cn.summerki.hashmap;

import org.jcp.xml.dsig.internal.SignerOutputStream;

import java.lang.reflect.Member;

/**
 * 自定义实现一个HashMap
 * @author summerki
 */
public class SummerkiHashMap01 {
    Node[] table; // 位桶数组. bucket array
    int size;     // 存放的键值对个数

    public SummerkiHashMap01(){
        table = new Node[16]; // 长度一般定义成2的整数次幂
    }

//    public void put(Object key, Object value){
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
//            table[newNode.hash] = temp;
//        }else{
//            // 此处数组元素不为空，则遍历对应链表
//            while(temp != null){
//                // 判断key如果重复，则覆盖
//                if(temp.key.equals(key)){
//                    System.out.println("key重复");
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

    public static void main(String[] args) {
        SummerkiHashMap01 summerkiHashMap01 = new SummerkiHashMap01();

//        summerkiHashMap01.put(10, "aa");
//        summerkiHashMap01.put(20, "bb");
//        summerkiHashMap01.put(30, "cc");
//
//        summerkiHashMap01.put(20, "ss");// 测试重写，有没有覆盖
//
//        summerkiHashMap01.put(53, "gg"); // 这3个数据的hash值相同，用来测试覆盖
//        summerkiHashMap01.put(69, "hh");
//        summerkiHashMap01.put(85, "kk");
    }


    public int myHash(int v, int length){
        System.out.println("hash in myHash:" + (v&(length - 1))); // 直接位运算，效率高
        System.out.println("hash in myHash:" + (v%(length - 1))); // 取模运算，效率低
        return v&(length - 1);
    }
}
