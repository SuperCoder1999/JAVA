package chapter14jihe.collection_.set_.linkedhashset;
import java.util.LinkedHashSet;
import java.util.Set;
/*
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
@SuppressWarnings({"all"})
public class LinkedHashSetSource {
    public static void main(String[] args) {
        //分析一下LinkedHashSet的底层机制
        Set set = new LinkedHashSet();
        set.add(new String("AA"));
        set.add(456);
        set.add(456);
        set.add(new Customer("刘", 1001));
        set.add(123);
        set.add("HSP");

        System.out.println("set=" + set);
        //解读
        //1. LinkedHashSet 加入顺序和取出元素/数据的顺序一致
        //2. LinkedHashSet 底层维护的是一个LinkedHashMap(是HashMap的子类)
        //3. LinkedHashSet 底层结构 (数组table+双向链表)
        //4. 添加第一次时，直接将 数组table 扩容到 16 ,存放的结点类型是 LinkedHashMap$Entry
        //5. 数组是 HashMap$Node[] 存放的元素/数据是 LinkedHashMap$Entry类型
        /*
                //继承关系是在内部类完成.
                static class Entry<K,V> extends HashMap.Node<K,V> {
                    Entry<K,V> before, after;
                    Entry(int hash, K key, V value, Node<K,V> next) {
                        super(hash, key, value, next);
                    }
                }

         */

    }
}
class Customer {
    private String name;
    private int no;

    public Customer(String name, int no) {
        this.name = name;
        this.no = no;
    }
}