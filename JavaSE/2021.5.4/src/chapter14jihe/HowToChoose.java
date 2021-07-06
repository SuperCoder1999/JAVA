package chapter14jihe;

/*
    在开发中如何选择集合实现类
    一： 首先判断存储的类型（一组对象[单列]或一组键值对[双列])
    1. 一组对象：Collection 接口
        1）允许重复：List
            增删多：LinkedList[底层维护了一个双向链表]
            查改多：ArrayList[底层维护Object类型的可变数组]
        2)不允许重复：Set
            无序：HashSet[底层走的是HashMap，维护了一个哈希表,即(数组+链表+红黑树)
            排序：TreeSet
            插入和取出顺序一致：LinkedHashSet[底层是LinkedHashMap，LinkedHashMap底层是HashMap]
                ，底层维护的是(数组+双向链表)
    2. 一组键值对[双列]：Map
        1）键无序：HashMap[底层是：哈希表[jdk7:数组+链表；jdk8:数组+链表+红黑树]
        2) 键排序：TreeMap
        3）键插入和取出顺序一致：LinkedHashMap
        4）读取文件：Properties

    二：线程安全性
    双线程         ： Vector
    ArrayList、LinkedList 不安全
    HashMap（TreeSet\TreeMap底层走的是HashMap)      不安全
    Hashtable     安全
 */

public class HowToChoose {
}
