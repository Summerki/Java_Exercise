package cn.summerki.hashmap;

/**
 * 新增泛型
 * 首先不再使用原来的GenericNode类,使用GenericNode类
 * 最终完成HashMap基本框架
 */
public class SummerkiHashMap04<K, V> {
    GenericNode[] table; // 位桶数组. bucket array
    int size;     // 存放的键值对个数

    public SummerkiHashMap04(){
        table = new GenericNode[16]; // 长度一般定义成2的整数次幂
    }

    public V get(K key){
        int hash = myHash(key.hashCode(), table.length);
        V value = null;

        // 只有在此处不为空的情况下才能找值啊
        if(table[hash] != null){
            GenericNode temp = table[hash];
            while(temp != null){
                if(temp.key.equals(key)){
                    value = (V)temp.value;
                    break;
                }else{
                    temp = temp.next;
                }
            }
        }
        return value;
    }

    public void put(K key, V value){

        // 如果要完善还需要考虑数组扩容的问题

        // 定义新的节点对象
        GenericNode newNode = new GenericNode();
        newNode.hash = myHash(key.hashCode(), table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;

        GenericNode temp = table[newNode.hash];

        GenericNode iterLast = null; // 正在遍历的最后一个元素

        boolean keyRepeat = false;

        if(temp == null){
            // 此处代表数组元素为空，则直接将新节点放进去
            table[newNode.hash] = newNode;
            size++;
        }else{
            // 此处数组元素不为空，则遍历对应链表
            while(temp != null){
                // 判断key如果重复，则覆盖
                if(temp.key.equals(key)){
//                    System.out.println("key重复");
                    keyRepeat = true;
                    temp.value = value; // 只是覆盖value即可。其他的值（hash、value、next）保持不变
                    break;
                }else{
                    // key不重复，则遍历下一个
                    iterLast = temp;
                    temp = temp.next;
                }
            }
            if(!keyRepeat){ // 没有发生key重复的情况下，则添加到链表的最后
                iterLast.next = newNode;
                size++;
            }
        }
    }

    @Override
    public String toString(){
        //{1:aa,2:bb}这种形式
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        // 遍历bucket数组
        for(int i = 0; i < table.length; i++){
            GenericNode temp = table[i];
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
        SummerkiHashMap04 summerkiHashMap04 = new SummerkiHashMap04();

        summerkiHashMap04.put(10, "aa");
        summerkiHashMap04.put(20, "bb");
        summerkiHashMap04.put(30, "cc");

        summerkiHashMap04.put(20, "ss");// 测试重写，有没有覆盖

        summerkiHashMap04.put(53, "gg"); // 这3个数据的hash值相同，用来测试覆盖
        summerkiHashMap04.put(69, "hh");
        summerkiHashMap04.put(85, "kk");

        System.out.println(summerkiHashMap04.toString());

        System.out.println(summerkiHashMap04.get(53));
    }


    public int myHash(int v, int length){
//        System.out.println("hash in myHash:" + (v&(length - 1))); // 直接位运算，效率高
//        System.out.println("hash in myHash:" + (v%(length - 1))); // 取模运算，效率低
        return v&(length - 1);
    }
}
