package cn.summerki.hashmap;

/**
 * 将原来的Node类变成现在的泛型Node类
 */
public class GenericNode<K, V> {
    int hash;
    K key;
    V value;
    GenericNode next;
}
