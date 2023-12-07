package chapter14jihe.collection_.set_.linkedhashset;

/*
    一：LinkedHashSet的说明
    1. LinkedHashSet是HashSet的子类
    2. LinkedHashSet底层是一个LinkedHashMap，底层维护了一个数组+双向链表
    3. LinkedHashSet根据元素的hashCode值来决定元素的存储位置，同时使用链表维护元素的次序，
    这使得元素来起来是以插入顺序保存的。
    4. LinkedHashSet不允许添加重复元素

    二.结论：
    1. 在LinkedHashSet中维护了一个hash表和双向链表（LinkedHashSet有head和tail）
    2. 每一个字节有before和after属性，这样可以形成双向链表
    3. 在添加一个元素(节点)时，先求hash值，再求索引。确定该元素在LinkedHashSet的位置，然后将添加的元素加入到
    双向链表（如果已经存在，不添加【原则和hashSet一样】）
    tail.next = newElement;
    newElement.pre = tail;
    tail = newElement;
    4. 这样的话，我们遍历LinkedHashSet也能确保插入顺序和遍历顺序一致。

 */

public class Introduce {
}
