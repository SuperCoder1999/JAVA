package chapter14jihe.collection_.list_.arraylist;

import java.util.ArrayList;

/*
    一：ArrayList的细节：
    1. permits all elements, including null。Arraylist可以加入null，并且可以放多null
    2. ArrayList是由数组来实现数据存储的
    3. ArrayList基本等同于Vector，除了ArrayList是线程不安全（执行效率高）。
        因此多线程下，不建议使用ArrayList

 */
@SuppressWarnings({"all"})
public class ArrayListDetail {
    public static void main(String[] args) {

        //ArrayList 是线程不安全的, 可以看源码 没有 synchronized
        /*  源码：
            public boolean add(E e) { 没有线程安全关键字
                ensureCapacityInternal(size + 1);  // Increments modCount!!
                elementData[size++] = e;
                return true;
            }
         */
        ArrayList arrayList = new ArrayList();
        arrayList.add(null);
        arrayList.add("jack");
        arrayList.add(null);
        arrayList.add("hsp");
        System.out.println(arrayList);
    }
}